package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Database;
import com.greenfox.webshop.model.ProductCategory;
import com.greenfox.webshop.model.Rates;
import com.greenfox.webshop.model.ShopItem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class Webshop {

  protected Database database = new Database();
  protected String currency = "EUR";
  protected double HUF = 353.60;
  protected String exchangeURL = "https://api.exchangeratesapi.io/latest?symbols=HUF";
  JSONObject ratesJSON;

  public void getExchangeRate() throws Exception {
//    URL exchangeURL = new URL("https://api.exchangeratesapi.io/latest?symbols=HUF");
//    HttpURLConnection connection = (HttpURLConnection) exchangeURL.openConnection();
//    connection.setRequestMethod("GET");
//    connection.setConnectTimeout(5000);
//    connection.setReadTimeout(5000);
//
//    InputStream resultStream = connection.getInputStream();
//    BufferedReader br1 = new BufferedReader(new InputStreamReader(resultStream));
//    String responseSingle;
//    StringBuffer response = new StringBuffer();
//    while ((responseSingle = br1.readLine()) != null) {
//      response.append(responseSingle);
//    }
//    br1.close();
//    connection.disconnect();


    RestTemplate restTemplate = new RestTemplate();
    Rates rates = restTemplate.getForObject("https://api.exchangeratesapi.io/latest", Rates.class);
    ratesJSON = new JSONObject(rates);
    ratesJSON.getJSONObject("rates").put("EUR", 1.0);   // Add base currency to the list

//    Object rates3 = restTemplate
//        .getForObject("https://api.exchangeratesapi.io/latest?symbols=HUF", Object.class);

//    BufferedReader br1 = new BufferedReader(rates.getBody().);
//    StringBuffer response = new StringBuffer();
//    response.append(rates.getBody());
//    JSONObject ratesObj = new JSONObject(response.toString());
    System.out.println(rates.toString());
    System.out.println(ratesJSON.getJSONObject("rates").get("HUF"));
    System.out.println(ratesJSON.getString("base"));
    System.out.println(ratesJSON.getString("date"));
//    HUF = Double.parseDouble(ratesJSON.getJSONObject("rates").getString("HUF"));

//    System.out.println(rates);
//    System.out.println(rates.getBody());
//    System.out.println(response.getStatusCode());
//    System.out.println(response.getBody());
  }

  @GetMapping("/webshop")
  public String listAllItems(Model model) throws Exception {
    if (ratesJSON == null) {
      getExchangeRate();
    }
    model.addAttribute("products", database.getProducts());
    model.addAttribute("currency", currency);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "index";
  }

  @GetMapping("/only-available")
  public String onlyAvailable(Model model) {
    List<ShopItem> onlyAvailable = database.getProducts().stream()
        .filter(product -> product.getQtyOfStock() > 0)
        .collect(Collectors.toList());

    model.addAttribute("products", onlyAvailable);
    model.addAttribute("currency", currency);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "index";
  }

  @GetMapping("/cheapest-first")
  public String cheapestFirst(Model model) {
    List<ShopItem> cheapestFirst = database.getProducts().stream()
        .sorted(Comparator.comparing(ShopItem::getPrice))
        .collect(Collectors.toList());

    model.addAttribute("products", cheapestFirst);
    model.addAttribute("currency", currency);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "index";
  }

  @GetMapping("/contains-nike")
  public String containsNike(Model model) {
    List<ShopItem> containsNike = database.getProducts().stream()
        .filter(product -> product.getName().toLowerCase().contains("nike") ||
            product.getDescription().toLowerCase().contains("nike"))
        .collect(Collectors.toList());

    model.addAttribute("products", containsNike);
    model.addAttribute("currency", currency);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "index";
  }

  @GetMapping("/most-expensive")
  public String mostExpensive(Model model) {
    Optional<ShopItem> mostExpensive = database.getProducts().stream()
        .filter(product -> product.getQtyOfStock() > 0)
        .max(Comparator.comparing(ShopItem::getPrice));

    ShopItem product = null;
    if (mostExpensive.isPresent()) {
      product = mostExpensive.get();
    }

    model.addAttribute("products", product);
    model.addAttribute("currency", currency);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "index";
  }

  @GetMapping("/average-stock")
  public String averageStock(Model model) {
    OptionalDouble averageStock = database.getProducts().stream()
        .mapToDouble(ShopItem::getQtyOfStock)
        .average();   //TODO what if is null?
    double average = 0.0;

    if (averageStock.isPresent()) {
      average = averageStock.getAsDouble();
    }

    model.addAttribute("average", average);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "average";
  }

  @PostMapping("/search")
  public String searchProduct(@RequestParam String searchBox, Model model) {
    String searchingFor = searchBox.toLowerCase().trim();

    List<ShopItem> result = database.getProducts().stream()
        .filter(product -> product.getName().toLowerCase().contains(searchingFor) ||
            product.getDescription().toLowerCase().contains(searchingFor))
        .collect(Collectors.toList());

    model.addAttribute("products", result);
    model.addAttribute("currency", currency);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "index";
  }

  @GetMapping("/more-filters")
  public String moreFilters(Model model) {
    model.addAttribute("products", database.getProducts());
    model.addAttribute("currency", currency);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "more";
  }

  @GetMapping("/filter-by-type/{type}")
  public String filterByType(@PathVariable String type, Model model) {
    ProductCategory filter = null;
    List<ShopItem> filteredByType;
    switch (type) {
      case "clothes-and-shoes":
        filter = ProductCategory.CLOTHES_SHOES;
        break;
      case "electronics":
        filter = ProductCategory.ELECTRONICS;
        break;
      case "beverages-and-snacks":
        filter = ProductCategory.BEVERAGES_SNACKS;
        break;
    }

    if (filter == null) {
      filteredByType =
          database.getProducts();    // It provide the full list, if user try manipulate the URL
    } else {
      ProductCategory finalFilter = filter;
      filteredByType = database.getProducts().stream()
          .filter(product -> product.getType() == finalFilter)
          .collect(Collectors.toList());
    }

    model.addAttribute("products", filteredByType);
    model.addAttribute("currency", currency);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "more";
  }

  @PostMapping("/filter-by-price")
  public String filterByPrice(@RequestParam String filter, @RequestParam double searchBoxPrice,
                              Model model) {
    List<ShopItem> filteredByPrice = new ArrayList<>();
    switch (filter) {
      case "Above":
        filteredByPrice = database.getProducts().stream()
            .filter(product -> product.getPrice() > searchBoxPrice)
            .collect(Collectors.toList());
        break;
      case "Below":
        filteredByPrice = database.getProducts().stream()
            .filter(product -> product.getPrice() < searchBoxPrice)
            .collect(Collectors.toList());
        break;
      case "Exactly":
        filteredByPrice = database.getProducts().stream()
            .filter(product -> product.getPrice() == searchBoxPrice)
            .collect(Collectors.toList());
        break;
    }

    model.addAttribute("products", filteredByPrice);
    model.addAttribute("currency", currency);
    model.addAttribute("filter", filter);
    model.addAttribute("filterValue", searchBoxPrice);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "index";
  }

  @GetMapping("/huf")
  public String displayHUF(Model model) {
    List<Double> pricesInHUF = new ArrayList<>();

    database.getProducts()
        .forEach(product -> pricesInHUF.add(product.getPrice() * HUF));

    model.addAttribute("products", database.getProducts());
    model.addAttribute("convertedPrice", pricesInHUF);
    model.addAttribute("currency", "HUF");
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "more";
  }

  @PostMapping("/convert")
  public String convertPrice(@RequestParam String convertTo, Model model) {
    List<Double> prices = new ArrayList<>();

    database.getProducts()
        .forEach(product -> prices.add(product.getPrice() *
            Double.parseDouble(ratesJSON.getJSONObject("rates").get(convertTo).toString())));

    model.addAttribute("products", database.getProducts());
    model.addAttribute("convertedPrice", prices);
    model.addAttribute("currency", convertTo);
    model.addAttribute("currencies", ratesJSON.getJSONObject("rates").keys());
    return "more";
  }
}

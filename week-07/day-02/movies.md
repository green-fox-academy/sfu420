# Movies exercise

The [sql file](data-movies.sql) for the database structure


## Exercise 1

Find the titles of all movies directed by Steven Spielberg.

``` text
                     title
1                     E.T.
2  Raiders of the Lost Ark

SELECT title FROM Movie WHERE director = "Steven Spielberg";
```

## Exercise 2

Find all years that have a movie that received a rating of 4 or 5, and sort them in increasing order.

``` text
  year
1 1937
2 1939
3 1981
4 2009

SELECT DISTINCT year FROM Movie INNER JOIN Rating ON Movie.mID = Rating.mID WHERE stars >= 4 ORDER BY year;
```

## Exercise 3

Find the titles of all movies that have no ratings.

``` text
      title
1 Star Wars
2   Titanic

SELECT title FROM Movie LEFT JOIN Rating ON Movie.mID = Rating.mID WHERE Rating.stars IS NULL;
```

## Exercise 4

Some reviewers didn’t provide a date with their rating. Find the names of all reviewers who have ratings with a NULL value for the date.

``` text
           name
1  Daniel Lewis
2 Chris Jackson

SELECT name FROM Reviewer LEFT JOIN Rating ON Reviewer.rID = Rating.rID WHERE ratingDate IS NULL;
```

## Exercise 5

Write a query to return the ratings data in a more readable format: reviewer name, movie title, stars, and ratingDate. Also, sort the data, first by reviewer name, then by movie title, and lastly by number of stars.

``` text
                name                   title stars ratingdate
 1      Ashley White                    E.T.     3 2011-01-02
 2   Brittany Harris Raiders of the Lost Ark     2 2011-01-30
 3   Brittany Harris Raiders of the Lost Ark     4 2011-01-12
 4   Brittany Harris      The Sound of Music     2 2011-01-20
 5     Chris Jackson                    E.T.     2 2011-01-22
 6     Chris Jackson Raiders of the Lost Ark     4       <NA>
 7     Chris Jackson      The Sound of Music     3 2011-01-27
 8      Daniel Lewis              Snow White     4       <NA>
 9  Elizabeth Thomas                  Avatar     3 2011-01-15
 10 Elizabeth Thomas              Snow White     5 2011-01-19
 11    James Cameron                  Avatar     5 2011-01-20
 12    Mike Anderson      Gone with the Wind     3 2011-01-09
 13   Sarah Martinez      Gone with the Wind     2 2011-01-22
 14   Sarah Martinez      Gone with the Wind     4 2011-01-27

SELECT Reviewer.name, Movie.title, stars, ratingDate FROM Rating INNER JOIN Movie ON Movie.mID = Rating.mID INNER JOIN Reviewer ON Rating.rID = Reviewer.rID ORDER BY Reviewer.name, title, stars;
```

## Exercise 6

For all cases where the same reviewer rated the same movie twice and gave it a higher rating the second time, return the reviewer’s name and the title of the movie.

``` text
            name              title
1 Sarah Martinez Gone with the Wind

SELECT Reviewer.name, m.title FROM Movie AS m INNER JOIN Rating AS r1 ON m.mID = r1.mID INNER JOIN Rating AS r2 ON m.mID = r2.mID INNER JOIN Reviewer ON r1.rID = Reviewer.rID WHERE r1.rID = r2.rID AND r1.ratingDate > r2.ratingDate AND r1.stars > r2.stars;
```

## Exercise 7 (Optional)

For each movie that has at least one rating, find the highest number of stars that movie received. Return the movie title and number of stars. Sort by movie title.

``` text
                    title max
1                  Avatar   5
2                    E.T.   3
3      Gone with the Wind   4
4 Raiders of the Lost Ark   4
5              Snow White   5
6      The Sound of Music   3
```

## Exercise 8 (Optional)

For each movie, return the title and the ‘rating spread’, that is, the difference between highest and lowest ratings given to that movie. Sort by rating spread from highest to lowest, then by movie title.

``` text
                    title rating_spread
1                  Avatar             2
2      Gone with the Wind             2
3 Raiders of the Lost Ark             2
4                    E.T.             1
5              Snow White             1
6      The Sound of Music             1
```

## Exercise 9 (Optional)

Find the difference between the average rating of movies released before 1980 and the average rating of movies released after 1980. (Make sure to calculate the average rating for each movie, then the average of those averages for movies before 1980 and movies after. Don’t just calculate the overall average rating before and after 1980.)

``` text
1 0.05555556
```


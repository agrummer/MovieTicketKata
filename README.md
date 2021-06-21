# Movie Tickets Coding Kata

It's your first day of work at your local movie theater and you've already got a crisis
on your hands. The theater recently upgraded all of the point of sale terminals to a 
new cloud-based solution from Congo Web Services (CWS), but now CWS has gone offline and 
none of your coworkers are able to do the math required to sell movie tickets.

You figure out that the fancy internet-enabled popcorn machine is running Java, so you grab
the theater ticket pricing menu and get to work building your own cash register. Your 
popcorn-powered cash register will need to calculate the total purchase price for each 
customer, and you'll need to work quickly... the line outside is growing!

**Customer satisfaction is important, so always charge the lowest possible price!**

## Ticket Pricing

| Basic admission rates (regular weekday, 2D movie, &lt;= 120 min, parquet) |            |
| ------------------------------------------------------------------------- | ---------: |
| General admission                                                         |     $11.00 |
| Students                                                                  |      $8.00 |
| Senior Citizens (65 & older)                                              |      $6.00 |
| Children (under 13)                                                       |      $5.50 |
| Group (20 people or more)                                                 | $6.00 each |

| Surcharges                         | Per Ticket |
| ---------------------------------- | ---------: |
| 3D movie                           |     +$3.00 |
| Over-length (more than 120 min)    |     +$1.50 |
| Weekends                           |     +$1.50 |
| Loge                               |     +$2.00 |

| Discounts                                      | Per Ticket |
| ---------------------------------------------- | ---------: |
| Movie Day Thursday (does not apply to groups!) |     -$2.00 |

#### Truths You Can Assume:
* 3D movies will always have "in 3D" at the end of their title
* Each customer can purchase any number of tickets, but all the tickets for that customer 
will always be for the same movie.
* A student can be any age (you're never too old to learn!)
* There are no age requirements for any of the movies (this is a family-friendly theater!)
* There are infinite seats available for all movies, so nothing is ever sold out.
* Customers must have at least 20 people physically present to qualify for the group rate 
  (ex: 19 people cannot purchase 20 tickets just to get the cheaper total price)  

---

### Extra Credit:
Once you have a working cash register, add the ability to generate a comma-separated values 
(CSV) file containing a human-readable summary of all the transactions that your cash register
has processed since it was initialized.

#### CSV file requirements:
* Filename should be the current date (ex: 2000-01-31.csv if today is January 31st, 2000)
* First row should be human-readable column names
* One row for each finalized purchase (no need to list each individual ticket)
* Last row should be the total sales revenue from all purchases


> Adapted from original "movie tickets coding kata" by Marco Dierenfeldt: 
> http://codingkata.org/katas/unit/movie-tickets
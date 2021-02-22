Bloom Filter is a space efficient probabilistic data structure that is used to test whether an element is in the set.
False positive matches are possible but false negatives are not. 
A query returns either "possible in set" or "definately not in set". 

* An empty bloom filter is a bit array of m bits, all set to 0.
* There must be k different hash functions defined, each of which hashes a key to one of the m positions.
* k << m, m proportional to number of elements added in the set
* Elements can be added to the set but not removed. For removal, setting a bit = 0 would mean we are removing some other element as well.
* Adding an element - Feed it to the k hash functions and set all those bits to 1
* Querying an element - Fed it to k hash functions. If even 1 bit is 0, then definitely not in set. Else in the set or false positive.
* Space Advantage - Bloom filter doesn't even require to store the whole data
* Hash tables = bloom filters with K=1 if hash tables don't count collision
* In hardware implementation, k lookups can be performed parallely

### Uses

* Cache Filtering - A web request url is cached only on its second request (removing on hit wonders) .
* Counting Bllom filters - Used to delete element from bloom filters
* Dedup in web crawler

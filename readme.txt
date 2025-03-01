a.  I'm using a generic fucntion which starts with a prime number and multiplies by a prime each
    iteration of a for loop. I got it from this stackoverflow post https://stackoverflow.com/a/2624210.

b.  Hashing provides constant search time at the cost of space. You are able to implement a lookup table
    using hashing which is faster than even a binary search tree or any other sort of lookup table implementation.
    This fast search/lookup time is at the cost of a lot of memory as we would ideally keep the load factor below
    a certain threshold. Also, hash tables can have a lot of collisions which end up making the data structure
    very convoluted leading to inefficiencies. An application of hashing/hash tables is in databases. Usually
    in databases you want the fastest retrieval possible, something which hash tables excel at.

c.  This assignment took me around 20 hours. This was probably the hardest assignment for me because I don't
    think I did it correctly. I was very, very confused about exactly what the assignment wanted us to implement.
    For example, we're asked to implement a HashMap and load the dictionary into it in order to compare running times,
    but again, I don't believe I implemented it correctly as this was my first time ever using HashMap. (somehow..)
    I was also very confused as to how we were to implement 'justifying' our hash function by comparing to Java's
    .hashcode() method. Given both of these challenges I really did try my best and I think my implementation make
    at least some sense! 
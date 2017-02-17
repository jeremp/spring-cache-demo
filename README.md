# Spring Cache Abstraction Demo

A very simple Spring-Boot application to show the usage of the [Spring Cache Abstraction](https://spring.io/guides/gs/caching/)

The app display a list of city, for each entry you can ask for more informations : 

* the number of people living int this city
* the mayor's name

Let's imagine that to get those additionnal informations we need to call an external old legacy systems which takes many time to give the result... 
we simulate this by adding a sleeping instruction in the CityDataService.**retrieveCityData** method.

Every Branch describes a step to improve the app : 

* *master* : the initial state, no cache, you've got to wait each time you want to display additional informations

* *with-cache* : enabling a cache with `@EnableCaching` and `@Cacheable` annotations. 
The first guy who ask for additionnal information about a particular city waits... the result is cached and the other asking for the same city won't wait. 
Unfortunatly, the cache never expires and if someone edit those information, the cache is not updated.

* *updating-cache* : The cache entry is removed when informations are modified.

* *refreshing-cache* : The cache entry is removed when informations are modified.
# RESTful API Design

## Table of Contents
<!-- TOC -->
* [RESTful API Design](#restful-api-design)
  * [Table of Contents](#table-of-contents)
  * [Defining Endpoints and URI Patterns](#defining-endpoints-and-uri-patterns)
    * [Example](#example)
  * [Query Parameters and Filtering](#query-parameters-and-filtering)
    * [Query Parameters:](#query-parameters)
    * [Filtering:](#filtering)
    * [Validation and Security](#validation-and-security)
    * [Documentation](#documentation)
  * [Pagination and Data Limiting](#pagination-and-data-limiting)
    * [Pagination Basics](#pagination-basics)
    * [Implementing Pagination:](#implementing-pagination)
    * [Handling Edge Cases](#handling-edge-cases)
    * [Sorting and Filtering with Pagination](#sorting-and-filtering-with-pagination)
    * [Default Values](#default-values)
    * [Caching and Optimization](#caching-and-optimization)
  * [Ref.](#ref)
<!-- TOC -->

---

## Defining Endpoints and URI Patterns

Endpoints are the specific URLs that clients use to interact with your API, and URI patterns define the structure and format of these URLs. Properly defining endpoints and URI patterns is essential for creating a consistent and user-friendly API. 

- ### Identify Resources

    _Start by identifying the resources that your API will expose_. Resources are the key entities or objects in your application that clients will interact with. In a library management system, for example, resources could include books, authors, and library branches.

<sub>[Back to top](#table-of-contents)</sub>

- ### Choose Resource Names

    _Select meaningful names for your resources_. These names should be nouns and represent the entities they describe. For example, use `books` for a resource that represents books and `authors` for a resource that represents authors.

<sub>[Back to top](#table-of-contents)</sub>

- ### Use Plural Nouns

    It's a common convention in **REST** to use plural nouns for resource names. _This makes it clear that you're dealing with a collection of items_. For example, use `/books` instead of `/book` to represent a collection of books.

<sub>[Back to top](#table-of-contents)</sub>

- ### Define URI Patterns

    **URI** patterns define the structure of your API's endpoints. T*hey should be consistent, predictable, and follow a hierarchical structure that reflects the relationships between resources*. Some common patterns include:

  - #### Basic Resource URI:

     `/resource`: Represents a collection of resources.
     `/resource/{id}`: Represents an individual resource with a unique identifier.
    
  - #### Nested Resource URI:

    `/resource/{id}/subresource`: Represents a nested resource within another resource.
    `/resource/{id}/subresource/{sub_id}`: Represents an individual nested resource.

  - #### Action or Operation URI:

    `/resource/{id}/action`: Represents an action or operation that can be performed on a resource.

  - #### Filtering and Querying URI:

    `/resource?param1=value1&param2=value2`: Allows clients to filter or query a collection of resources based on parameters.

  - #### Versioning URI:

    `/v1/resource`: To indicate the version of your API (e.g., v1) in the URI.

  - #### Custom URI Patterns: 
    You can define custom URI patterns that make sense for your application's domain and use cases.

<sub>[Back to top](#table-of-contents)</sub>

- ### Consistency and Predictability:

Keep the URI patterns consistent throughout your API to make it easier for developers to understand and use. Predictability is also essential; users should be able to guess resource URIs based on established patterns.

<sub>[Back to top](#table-of-contents)</sub>

- ### Avoid Verb-based URIs:

In **REST**, HTTP methods (`GET`, `POST`, `PUT`, `DELETE`, etc.) are used to indicate the action to be taken on a resource. 
>Avoid using verbs in your URI patterns, as this goes against RESTful principles.

 - See also: [HTTP Verbs](restful.md#http-verbs)
  

  <sub>[Back to top](#table-of-contents)</sub>
  
- ### Document Your API:

Clearly document your API, including the URI patterns, in your API documentation. This helps developers understand how to interact with your API and ensures consistent usage.

 - See also: [OpenAPI]()<!--TODO-->
 - See also: [Swagger]()<!--TODO-->


### Example

Here's an example of URI patterns for a simple library management API:

- `/books`: Represents a collection of books.
- `/books/{book_id}`: Represents an individual book.
- `/authors`: Represents a collection of authors.
- `/authors/{author_id}`: Represents an individual author.
- `/books/{book_id}/borrow`: Represents an action to borrow a book.

>By following these steps and guidelines, you can define endpoints and URI patterns that make your RESTful API intuitive and easy to use for both developers and clients.
 
 - See also: [API Design Principles](api-design-principles.md)
 - See also: [Resource Design and Representation](resource-design-representation.md)
  

  <sub>[Back to top](#table-of-contents)</sub>
  

## Query Parameters and Filtering

### Query Parameters:

Query parameters are _key-value pairs included in the URL_ of an HTTP request after a question mark `?` and separated by ampersands `&`. They are used to customize the behavior of a request, such as _filtering_, _sorting_, or _paginating_ the data. Query parameters are optional, and clients can include one or more of them in a request to tailor the response to their needs.

Common query parameters include:

- #### Filtering Parameters:
  Used to filter resources based on specific criteria.
  
  - `/books?author=Stephen+King`: fetches all books written by Stephen King


- #### Sorting Parameters:
  Used to specify the sorting order of the results. 
  - `/books?sort=title`: retrieves books sorted by title in ascending order.
  

- #### Pagination Parameters:
  Used to control the number of results per page and navigate through large data sets.

  - `/books?page=2&per_page=10`: retrieves the second page of 10 books per page.
  
 
- #### Search Parameters: 
  Used for full-text search or keyword-based filtering.

  - `/books?query=science+fiction`: searches for books containing the term "science fiction."

- #### Fields Parameters:
  Used to specify which fields of a resource should be included in the response.

  - `/books?fields=title,author`: fetches only the title and author fields of books.
  
- #### Custom Parameters:
  You can define custom query parameters to support specific functionalities in your API.


  <sub>[Back to top](#table-of-contents)</sub>
  
### Filtering:

Filtering is the process of selecting a subset of resources from a collection based on specific conditions or criteria. It allows clients to narrow down their search and retrieve only the data that meets their requirements. Filtering is often accomplished using query parameters.

Example of filtering in a REST API:

- Retrieves electronic products with a maximum price of $500:
  ```http request
  GET /products?category=electronics&price_max=500
  ``` 


- Fetches active employees in the engineering department:
  ```http request
  GET /employees?department=engineering&status=active
  ```

> Filtering can be as simple or as complex as needed, depending on the API's capabilities and the data model.


<sub>[Back to top](#table-of-contents)</sub>

### Validation and Security

When implementing query **parameters** and **filtering** in your REST API, it's essential to _validate and sanitize input to prevent security vulnerabilities_ like SQL injection or other attacks. Ensure that query parameters are validated against acceptable values and constraints.

 - See also: [SQL Injection]()<!--TODO: -->
 - See also: [Cross-Site Scripting (XSS):]()<!--TODO: -->
   
  

  <sub>[Back to top](#table-of-contents)</sub>
  
### Documentation

Clearly document the available query parameters, their usage, and the expected behavior in your API documentation. This helps developers understand how to use filtering and query parameters effectively.


- See also: [OpenAPI]()<!--TODO-->
- See also: [Swagger]()<!--TODO-->


<sub>[Back to top](#table-of-contents)</sub>


>In summary, query parameters and filtering are powerful features in a REST API that enhance its flexibility and usability. They allow clients to request specific subsets of data, sort results, paginate through large data sets, and customize their interactions with the API based on their needs. Properly implementing and documenting these features can greatly improve the developer experience and make your API more versatile.


<sub>[Back to top](#table-of-contents)</sub>

## Pagination and Data Limiting

Pagination and data limiting are essential techniques for managing large datasets in a RESTful API. They _allow clients to retrieve a subset of the data in a controlled and efficient manner_, which is especially important when dealing with large collections of resources.

### Pagination Basics

Pagination divides a large dataset into smaller **"pages"** or chunks of data, making it easier for clients to navigate through the dataset. The key components of pagination are the page and per_page parameters:

 - `page`: Specifies the page number to retrieve. It typically starts at 1 for the first page.
 - `per_page`: Defines the number of items to include on each page.

For example, if you have a collection of 100 books and you set per_page to 10, you can retrieve the first 10 books on page 1, the next 10 books on page 2, and so on.

### Implementing Pagination:

 - #### Add Pagination Parameters to the Endpoint:
  Modify your endpoint to accept the `page` and `per_page` query parameters. For example:

```http request
  GET /books?page=2&per_page=10
```
 
 - #### Calculate Offset and Limit:
 In your API code, calculate the `offset` and `limit` based on the values of `page` and per_page. 
  The `offset` determines where to start fetching data, and the `limit` specifies the maximum number of items to return.

```javascript
offset = (page - 1) * per_page
limit = per_page
```
  
- #### Retrieve and Return Data:
  Use the offset and limit values to retrieve the appropriate subset of data from your database or data source. Return this data as the response to the client.

- #### Include Pagination Metadata:
  In the API response, include metadata that informs clients about the current page, total number of pages, and total count of items. This helps clients navigate through the dataset.


```json
{
  "data": [/* Array of items */],
  "meta": {
    "page": 2,
    "per_page": 10,
    "total_pages": 10,
    "total_items": 100
  }
}  
```


<sub>[Back to top](#table-of-contents)</sub>


### Handling Edge Cases

Be prepared to handle edge cases, such as when the requested page number exceeds the total number of pages or when invalid values are provided for page or per_page.
You can enforce limits on `per_page` to prevent excessively large requests.

<sub>[Back to top](#table-of-contents)</sub>


### Sorting and Filtering with Pagination

Clients may want to sort or filter data while paginating. Ensure that your API supports these features by allowing sorting and filtering query parameters.

<sub>[Back to top](#table-of-contents)</sub>


```http request
GET /books?page=2&per_page=10&sort=title&filter=author:Stephen+King
```

<sub>[Back to top](#table-of-contents)</sub>

### Default Values

Consider providing default values for page and per_page in case clients don't specify them in their requests. This helps ensure a consistent user experience.

<sub>[Back to top](#table-of-contents)</sub>

### Caching and Optimization

 - Implement caching strategies to reduce the load on your server, especially for frequently requested pages.

   - See also: [Caching]()<!--TODO: -->
  

 - Optimize database queries to efficiently retrieve paginated data.



>Pagination and data limiting enhance the usability and performance of your API, especially when dealing with large datasets. They provide clients with control over the amount of data they retrieve while maintaining a predictable and user-friendly experience.


<sub>[Back to top](#table-of-contents)</sub>

---

## Ref.

- https://www.oreilly.com/library/view/restful-web-services/9780596529260/
- https://cloud.google.com/apis/design?hl=es-419

---

[Get Started](../../../get-started.md) |
[Web Services and API Design](../../../get-started.md#web-services-and-api-design)

___
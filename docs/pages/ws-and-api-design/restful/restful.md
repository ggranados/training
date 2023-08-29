# RESTful Architecture

---

## Table of Contents
<!-- TOC -->
* [RESTful Architecture](#restful-architecture)
  * [Table of Contents](#table-of-contents)
  * [Introduction to REST Architecture](#introduction-to-rest-architecture)
    * [What is REST?](#what-is-rest)
    * [Key Principles of REST](#key-principles-of-rest)
    * [Evolution and History of REST](#evolution-and-history-of-rest)
    * [Advantages of REST Architecture](#advantages-of-rest-architecture)
  * [HTTP Fundamentals](#http-fundamentals)
    * [Understanding HTTP Verbs (GET, POST, PUT, DELETE, etc.)](#understanding-http-verbs-get-post-put-delete-etc)
    * [URI (Uniform Resource Identifier) and URL (Uniform Resource Locator)](#uri-uniform-resource-identifier-and-url-uniform-resource-locator)
    * [Request and Response Headers](#request-and-response-headers)
    * [Status Codes in REST](#status-codes-in-rest)
* [Resource Design and Representation](#resource-design-and-representation)
    * [Identifying Resources and Resource Hierarchy](#identifying-resources-and-resource-hierarchy)
    * [Resource Representation Formats (XML, JSON, etc.)](#resource-representation-formats-xml-json-etc)
    * [Data Modeling for REST APIs](#data-modeling-for-rest-apis)
    * [Handling Relationships between Resources](#handling-relationships-between-resources)
  * [RESTful API Design](#restful-api-design)
    * [Defining Endpoints and URI Patterns](#defining-endpoints-and-uri-patterns)
    * [Query Parameters and Filtering](#query-parameters-and-filtering)
    * [Pagination and Data Limiting](#pagination-and-data-limiting)
    * [Versioning APIs](#versioning-apis)
    * [Hypermedia as the Engine of Application State (HATEOAS)](#hypermedia-as-the-engine-of-application-state-hateoas)
  * [Statelessness and Caching](#statelessness-and-caching)
    * [Stateless Architecture in REST](#stateless-architecture-in-rest)
    * [Benefits and Challenges of Statelessness](#benefits-and-challenges-of-statelessness)
    * [Caching Strategies and HTTP Caching Headers](#caching-strategies-and-http-caching-headers)
  * [Security and Authentication](#security-and-authentication)
    * [Authentication vs. Authorization](#authentication-vs-authorization)
    * [Token-based Authentication (JWT, OAuth)](#token-based-authentication-jwt-oauth)
    * [Securing REST APIs (TLS, HTTPS, CORS)](#securing-rest-apis-tls-https-cors)
  * [Error Handling and Exception Management](#error-handling-and-exception-management)
    * [Common Error Response Patterns](#common-error-response-patterns)
    * [Handling Errors and Exception Scenarios](#handling-errors-and-exception-scenarios)
    * [Providing Meaningful Error Messages](#providing-meaningful-error-messages)
  * [Best Practices and Guidelines](#best-practices-and-guidelines)
    * [Naming Conventions for Resources and Endpoints](#naming-conventions-for-resources-and-endpoints)
    * [Keeping APIs Consistent and Predictable](#keeping-apis-consistent-and-predictable)
    * [Performance Optimization Techniques](#performance-optimization-techniques)
    * [Documentation and API Contracts](#documentation-and-api-contracts)
  * [Real-world Examples and Case Studies](#real-world-examples-and-case-studies)
    * [Building a RESTful API for a Blogging Platform](#building-a-restful-api-for-a-blogging-platform)
    * [Integrating Third-Party Services via REST](#integrating-third-party-services-via-rest)
    * [Scaling and Load Balancing REST APIs](#scaling-and-load-balancing-rest-apis)
  * [Future Trends in REST Architecture](#future-trends-in-rest-architecture)
    * [GraphQL vs. REST](#graphql-vs-rest)
    * [Serverless Architectures and REST](#serverless-architectures-and-rest)
    * [Webhooks and Event-Driven REST APIs](#webhooks-and-event-driven-rest-apis)
  * [Conclusion](#conclusion)
    * [Recap of Key Concepts](#recap-of-key-concepts)
    * [Importance of REST in Modern Software Development](#importance-of-rest-in-modern-software-development)
  * [Additional Resources](#additional-resources)
    * [Recommended Books and Online Materials](#recommended-books-and-online-materials)
    * [Relevant Online Courses and Tutorials](#relevant-online-courses-and-tutorials)
    * [Tools and Frameworks for Building RESTful APIs](#tools-and-frameworks-for-building-restful-apis)
<!-- TOC -->

---

## What is REST?

REST stands for "Representational State Transfer." It is an **architectural style** and set of constraints used in *designing and structuring networked applications*, particularly *web services and APIs*.

REST is commonly used to build distributed, stateless and reliable Web-based systems that allow different software components to communicate over a network, typically the internet.

This architectural style emphasises the scalability of interactions between components, uniform interfaces, independent deployment of components, and the creation of a layered architecture to facilitate caching of components to reduce user-perceived latency, enforce security, and encapsulate legacy systems.

<sub>[Back to top](#table-of-contents)</sub>

# Architectural constraints

REST defines six guiding constraints. When these constraints are applied to the system architecture, it gains desirable non-functional properties, such as _performance_, _scalability_, _simplicity_, _modifiability_, _visibility_, _portability_, and _reliability_

<sub>[Back to top](#table-of-contents)</sub>

- ### Statelessness
  Each request from a client to a server must contain all the information necessary for the server to understand and process the request. _The server should not store any client context between requests_. This design promotes scalability and simplifies server maintenance.

<sub>[Back to top](#table-of-contents)</sub>

- ### Client-Server Architecture
  REST _separates the concerns of client and server components_, allowing them to evolve independently. Clients are responsible for the user interface and user experience, while servers handle data storage, processing, and management.

<sub>[Back to top](#table-of-contents)</sub>

- ### Cacheability
 Responses from the server can be labeled as `cacheable` or `non-cacheable`. Caching allows clients to _reuse previously fetched data_, reducing the need for repeated requests to the server and improving performance.

<sub>[Back to top](#table-of-contents)</sub>

- ### Uniform Interface
  REST _employs a consistent and uniform set of operations_ (`HTTP` methods) to interact with resources. These methods include `GET` (retrieve), `POST` (create), `PUT` (update), and `DELETE` (remove).

<sub>[Back to top](#table-of-contents)</sub>

- ### Layered System
  A layered architecture _enables intermediaries, such as proxies and gateways, to be placed between clients and servers without affecting the overall system behavior_. This enhances scalability, flexibility, and security.

<sub>[Back to top](#table-of-contents)</sub>

- ### Code on Demand (Optional)
  Servers _can provide executable code to clients on-demand_. This feature is optional in the REST architecture and _is rarely used in practice_.

  >Historically, this constraint was more relevant in the early days of the web when web browsers were less capable and had limited scripting capabilities. However, with the advancement of web technologies, most dynamic behavior and interactivity are achieved using other techniques such as AJAX (Asynchronous JavaScript and XML) and modern JavaScript frameworks.
  >Old Java applets are an example of the "Code on Demand" constraint in the context of the REST architectural style 

<sub>[Back to top](#table-of-contents)</sub>

## HTTP Fundamentals

HTTP stands for "Hypertext Transfer Protocol." It is the fundamental protocol that underpins data communication on the World Wide Web. HTTP is an application layer protocol used for transmitting various types of data, such as HTML documents, images, videos, and other resources, between a client (typically a web browser) and a server (hosting websites and web applications).

-See also [HTTP & HTTPS]()<!--TODO-->

<sub>[Back to top](#table-of-contents)</sub>

### HTTP Verbs

HTTP defines several methods that indicate the desired action to be performed on a resource. The most commonly used methods in REST are:

- **GET**: Retrieve a resource.
  ```http request
  GET /api/posts/123 HTTP/1.1
  Host: www.example.com
  ```

- **POST**: Create a new resource.
  ```http request
  POST /api/users HTTP/1.1
  Host: www.example.com
  Content-Type: application/json
  
  {
  "name": "John Doe",
  "email": "john@example.com"
  }
  ```

- **PUT**: Update or replace an existing resource.
  ```http request
  PUT /api/products/456 HTTP/1.1
  Host: www.example.com
  Content-Type: application/json
  
  {
  "name": "Updated Product",
  "price": 29.99
  }
  ```
  
- **PATCH**: Partially update an existing resource.
  ```http request
  PATCH /api/orders/789 HTTP/1.1
  Host: www.example.com
  Content-Type: application/json
  
  {
  "status": "shipped"
  }
  ```

- **DELETE**: Remove a resource.
  ```http request
  DELETE /api/comments/321 HTTP/1.1
  Host: www.example.com
  ```

<sub>[Back to top](#table-of-contents)</sub>

### URI (Uniform Resource Identifier) and URL (Uniform Resource Locator)

URIs are used to uniquely identify resources. In RESTful APIs, URIs are used to address resources, and they should be designed to be meaningful and hierarchical. For example:

```http request
GET /api/users/123
```

URL (Uniform Resource Locator): A URL is a specific type of URI that not only identifies a resource but also provides the means to locate it. It includes the information needed to access a resource, such as the _protocol_ (e.g., HTTP), _domain name_, _port number_, _path_, and _query parameters_. URLs are used to specify the location of web pages, images, files, and other resources on the internet. For example:

```thymeleafurlexpressions
https://www.example.com:8080/products?id=123&page=1#details
```

<sub>[Back to top](#table-of-contents)</sub>

### Request and Response Headers
HTTP headers contain additional information about the request or response. Some important headers in REST include:

- **Content-Type**: Specifies the format of the data being sent or received (e.g., JSON, XML).
  ```
  Content-Type: application/json
  ```
  - See also: [Resource Representation Formats]()<!--TODO-->  

- **Accept**: Informs the server about the preferred response format.
  ```
  Accept: application/json
  ```

- **Authorization**: Used for sending credentials or tokens for authentication.
  ```
  Authorization: Bearer your_access_token
  ```
  
  - See also: [Authentication & Authorization](../authn-and-authz/authn-authz.md)


- **Cache-Control**: Specifies caching directives for both requests and responses.
  ```
  Cache-Control: max-age=3600
  ```
  - See also: [Caching]()<!--TODO-->  

 - **User-Agent**: Identifies the client making the request, often the web browser or client application.
  ```
  User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36
  ```
- **Cookie**: Sends previously stored cookies to the server for identification and session tracking.
  ```
  Cookie: session_id=abc123; user_id=789
  ```

- **Location**: Used in responses to specify the location of a newly created resource.
  ```
  Location: /api/orders/456
  ```

- **If-None-Match**:Allows conditional requests based on resource's ETag (entity tag) value.
  ```
  If-None-Match: "etag_value"
  ```

- **Referer**: Provides the URL of the referring page, often used for tracking purposes.
  ```
  Referer: https://www.example.com/page1
  ```

<sub>[Back to top](#table-of-contents)</sub>

### HTTP Status Codes in REST

HTTP status codes are three-digit numbers sent by the server in response to a client's request. They provide information about the outcome of the request. Common status codes in REST include:

- **200 OK**: The request was successful.

- **201 Created**: The request resulted in a new resource being created.

- **204 No Content**: The request was successful, and there is no content to send in the response.

- **400 Bad Request**: The request was malformed or invalid.

- **401 Unauthorized**: Authentication is required and has failed or has not been provided.

- **404 Not Found**: The requested resource could not be found.

- **500 Internal Server Error**: An error occurred on the server.


- See also: [HTTP Status Codes]()<!--TODO-->


<sub>[Back to top](#table-of-contents)</sub>



---

## Ref.

- https://en.wikipedia.org/wiki/Representational_state_transfer

---

[Get Started](../../../get-started.md) |
[Web Services and API Design](../../../get-started.md#web-services-and-api-design)

___
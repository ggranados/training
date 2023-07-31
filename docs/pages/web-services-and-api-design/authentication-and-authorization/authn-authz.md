# Authentication (AuthN) and Authorization (AuthZ)

---

## Table of Content

---

## Overview
AuthN and AuthZ refer to two fundamental aspects of controlling access to resources and ensuring the confidentiality and integrity of sensitive information within a system.

By combining strong authentication and precise authorization mechanisms, IT systems can enforce security and prevent unauthorized access to sensitive data and resources, thereby protecting against data breaches and unauthorized activities.

## Authentication (AuthN):
*AuthN*, short for "*Authentication*," is the process of verifying the identity of a user, system, or device attempting to access a particular resource or service. The primary goal of authentication is to ensure that *only legitimate and authorized entities are granted access while keeping unauthorized users out*.

Authentication methods typically involve the presentation of credentials by the user, which are then compared against pre-registered or pre-issued data to validate the identity.

Common authentication factors include:

- **Knowledge-based factors**: Such as passwords or personal identification numbers (PINs).


- **Possession-based factors**: Such as physical tokens or one-time password (OTP) generators.


- **Inherence-based factors**: Such as biometric characteristics like fingerprints, facial recognition, or retinal scans.


- **Location-based factors**: Such as validating the user's location through GPS or IP geolocation.

>To enhance security, many systems now employ Multi-Factor Authentication (MFA) where users must provide two or more of these factors for an extra layer of protection.


### Authentication Methods (AuthN):

- **Password-based authentication**: Users provide a unique password to prove their identity.


- **JSON web token**:  JSON web token or JWT is an open standard used to securely transmit the data between the parties in the form of the JSON object. The users are verified and authorized using the private/public key pair. 
    >It is not a standalone authorization mechanism

    - See also: [JSON Web Token](jwt.md)


- **Multi-Factor Authentication (MFA)**: Requires users to provide multiple forms of identification, such as a password, a one-time code sent to their phone, or biometric data (fingerprint, face recognition).
Public Key Infrastructure (PKI): Uses public and private key pairs for authentication.


- **OAuth**: An open standard for authorization, allowing users to grant third-party applications access to their resources without sharing their credentials.


- **OpenID Connect**: An extension of OAuth, providing identity layer on top of it, allowing for authentication.


- **SAML (Security Assertion Markup Language)**: An XML-based protocol for exchanging authentication and authorization data between parties.


- **LDAP (Lightweight Directory Access Protocol)**: A protocol for accessing and maintaining directory information services. Often used for centralized authentication.


- **Kerberos**: A network authentication protocol designed to provide strong authentication for client/server applications.


- **Biometric Authentication**: Using unique physical characteristics (fingerprint, iris, voice) to verify identity.


- **Certificate-based authentication**: Users provide a digital certificate to verify their identity.


## Authorization (AuthZ):

Authorization is the process of determining *what actions, resources, or services an authenticated user or entity is permitted to access*. It involves granting appropriate privileges and permissions to users based on their *role*, *identity*, or *attributes*.

Authorization is typically governed by access control policies that define the rules and restrictions for different user groups or roles. These policies may include **Role-Based Access Control (RBAC)**, **Attribute-Based Access Control (ABAC)**, and other access control models.

>The authorization mechanism ensures that users are only allowed to perform actions that are within their defined scope and permissions.


### Authorization Methods (AuthZ):

- **JSON web token**: While JWT is an authentication mechanism, it can indirectly contribute to authorization (AuthZ). For example, once the server validates the JWT's signature and authenticity, it can use the information within the JWT (claims) to determine the user's role, permissions, or access rights

    - See also: [JSON Web Token](jwt.md)


- **Role-based Access Control (RBAC)**: Assigns permissions based on predefined roles, and users are assigned to specific roles.


- **Attribute-based Access Control (ABAC)**: Access decisions are based on attributes and policies defined for resources and users.


- **Discretionary Access Control (DAC)**: Access control is at the owner's discretion, allowing them to set permissions on their resources.


- **Mandatory Access Control (MAC)**: Access decisions are made by a central authority based on predefined security classifications.


- **Rule-based Access Control (RBAC)**: Access control is determined by a set of rules.


- **Policy-based Access Control**: Access control decisions are based on a set of rules and policies.


- **Claims-based Access Control**: Access decisions are made based on claims or attributes associated with the user.





___

## Ref.

- https://www.cloudflare.com/learning/access-management/authn-vs-authz/

---

[Get Started](../../../get-started.md) |
[Web Services and API Design](../../../get-started.md#web-services-and-api-design)

___


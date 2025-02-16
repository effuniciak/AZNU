## Library network management software

### This application is made of following micro-services:
#### libraries-frontend/ contain web front for user

#### library-client/ serves RESTful endpoints for libraries-frontend

#### library-manager/ provides global data about books

#### libraries-db/ provides data about availability of books in certain physical stores
- it stores only indeces of books that correspond to book objects provided by library-manager

### Library-client communicates with library-manager and libraries-db using SOAP protocol 
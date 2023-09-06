# LabSeq Application

This repository contains the containerized version of the LabSeq Application returning a value from the labseq
sequence defined as  l(n) = l(n-4) + l(n-3)



## Prerequisites

1. Install [Docker](https://www.docker.com/products/docker-desktop) on your system.

## Getting Started

### Pulling the Docker Image

To pull the Docker image from Docker Hub:

```
docker pull josilva00/labseq:v1
```

### Running the Application
After pulling the image, you can run the application using:

```
docker run -p 8080:8080 josilva00/labseq:v1
```

This will start the application and bind it to port 8080 on your host.

### Accessing the Application
Once the application is running, you can access the web GUI by navigating to:
```
http://localhost:8080
```
Or access the endpoint directly using:
```
http://localhost:8080/labseq/{n}
```
where {n}
represents the index of the sequence’s (single) value to return
The index may be any non-negative integer number.

# Documentation
The REST API documentation can be accessed by navigating to:
```
http://localhost:8080/swagger-ui/index.html
```

# Implementation choices

Due to the acceptable O(n) time complexity of the implemented algorithm, i chose to only cache the endpoint’s invocations to save on space complexity.

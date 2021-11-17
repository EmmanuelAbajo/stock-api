# Stock API
This is a dockerized microservice for stocks. It provides endpoints for common CRUD operations for the stock object. The stock object comprises name and current_price of the stock.

## Setup
To build the docker image, run `docker build -t stock-api`

To spin up a container from the create image, run `docker run -p 8080:8080 -d stock-api`

View api documentation at `http://localhost:8080/swagger-ui.html`


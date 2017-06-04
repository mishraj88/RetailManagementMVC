# RetailManagementMVC
Spring Boot Application for Reatail Mangement using REST WebService

I have this simple appliication
which has 2 model classes

one with Shop model class which composes an Address class reference to
represent the shop's address

Get request for all shops: http://localhost:8080/shops

output would be like:

[
  {
    "id": "Shop_1",
    "shopName": "MyFashionStop",
    "shopAddress": {
      "shopNumber": "15A",
      "shopStreet": "Green Park Market",
      "shopcity": "New Delhi"
    }
  },
  {
    "id": "Shop_2",
    "shopName": "MyShoeStop",
    "shopAddress": {
      "shopNumber": "11A",
      "shopStreet": "South Extension Market",
      "shopcity": "New Delhi"
    }
  },
  {
    "id": "Shop_3",
    "shopName": "MyGeekyStop",
    "shopAddress": {
      "shopNumber": "15/26-PoketA",
      "shopStreet": "Nehru Place",
      "shopcity": "New Delhi"
    }
  },
  {
    "id": "Shop_4",
    "shopName": "MyGameStop",
    "shopAddress": {
      "shopNumber": "209B",
      "shopStreet": "Cannaught Place",
      "shopcity": "New Delhi"
    }
  }
]


2- to get a specific shop details":

say: sop with id= Shop_1

Get request: localhost:8080/shops/Shop_1

and the output would be:

{
  "id": "Shop_1",
  "shopName": "MyFashionStop",
  "shopAddress": {
    "shopNumber": "15A",
    "shopStreet": "Green Park Market",
    "shopcity": "New Delhi"
  }
}


3- PUT request to update details about certain shop
the controller method for this activity expects to have Shop object as
a parameter and a shop.id, to look for the shop object whose content
is to be updated.

(we are going to edit details of shop with id= Shop_1)
(we provide a JSON input for newUpdatedShopDetails object and on
headers set contenten-type to application/json)
JSON input:

{
  "id": "Shop_1",
  "shopName": "MyFashionStop2",
  "shopAddress": {
    "shopNumber": "15A",
    "shopStreet": "Green Park Market",
    "shopcity": "New Delhi"
  }
}

PUT URL: http://localhost:8080/shops/Shop_1

output:
//String.format("%s has changed to %s", oldShopDetails.toString(),
newUpdatedShopDetails.toString());
Shop [id=Shop_1, shopName=MyFashionStop, shopAddress=Address
[shopNumber=15A, shopStreet=Green Park Market, shopcity=New Delhi]]
has changed to Shop [id=Shop_1, shopName=MyFashionStop2,
shopAddress=Address [shopNumber=15A, shopStreet=Green Park Market,
shopcity=New Delhi]]


4- Add a new Shop object:

input is JSON:

{
  "id": "Shop_5",
  "shopName": "MyFashionStop3",
  "shopAddress": {
    "shopNumber": "256A",
    "shopStreet": "Kalu Sarai Market",
    "shopcity": "New Delhi"
  }
}

Header: Content-type: application/json

POST URL: http://localhost:8080/shops

Output(same json object):

{
  "id": "Shop_5",
  "shopName": "MyFashionStop3",
  "shopAddress": {
    "shopNumber": "256A",
    "shopStreet": "Kalu Sarai Market",
    "shopcity": "New Delhi"
  }
}

DELETE:
we will remove the shop from inventory with a specific id.
The controller method receives this ID from the URL path itself using
@PathVariable annotation
(we are going to remove a shop object with id= Shop_4

DELETE URL: http://localhost:8080/shops/Shop_4

output:
//String.format("%s has been deleted from the shop inventory",
removedShopDetails.toString());
Shop [id=Shop_4, shopName=MyGameStop, shopAddress=Address
[shopNumber=209B, shopStreet=Cannaught Place, shopcity=New Delhi]] has
been deleted from the shop inventory

After this request if you run the GetAllShops request:

GET: http://localhost:8080/shops

output(Json array object with Shop object with id ="Shop_4":

[
  {
    "id": "Shop_1",
    "shopName": "MyFashionStop2",
    "shopAddress": {
      "shopNumber": "15A",
      "shopStreet": "Green Park Market",
      "shopcity": "New Delhi"
    }
  },
  {
    "id": "Shop_2",
    "shopName": "MyShoeStop",
    "shopAddress": {
      "shopNumber": "11A",
      "shopStreet": "South Extension Market",
      "shopcity": "New Delhi"
    }
  },
  {
    "id": "Shop_3",
    "shopName": "MyGeekyStop",
    "shopAddress": {
      "shopNumber": "15/26-PoketA",
      "shopStreet": "Nehru Place",
      "shopcity": "New Delhi"
    }
  },
  {
    "id": "Shop_5",
    "shopName": "MyFashionStop3",
    "shopAddress": {
      "shopNumber": "256A",
"shopStreet": "Kalu Sarai Market",
      "shopcity": "New Delhi"
    }
  }
]


I have added the executable jar, which can be found at:

RetailManagementMVC/RetailManagementMVC/build/libs/RetailManagementMVC-0.0.1-SNAPSHOT.jar


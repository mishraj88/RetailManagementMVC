# RetailManagementMVC
Spring Boot Application for Reatail Mangement using REST WebService

I have this simple appliication
which has 2 model classes- Shop.java and Address.java

I have used Google GeoCoding API for longitude and latitude information using Shop's street and city received it in xml format and parsed it to getlongitude and latitude.


1- Get request for all shops: http://localhost:8081/shops

output would be like:

{
    "Shop_4": {
        "id": "Shop_4",
        "shopName": "MyGameStop",
        "shopAddress": {
            "shopNumber": "209B",
            "shopStreet": "Connaught Place",
            "shopcity": "New Delhi",
            "latitude": "28.6314512",
            "longitude": "77.2166672"
        }
    },
    "Shop_3": {
        "id": "Shop_3",
        "shopName": "MyGeekyStop",
        "shopAddress": {
            "shopNumber": "15/26",
            "shopStreet": "Nehru Place",
            "shopcity": "New Delhi",
            "latitude": "28.5503314",
            "longitude": "77.2501893"
        }
    },
    "Shop_2": {
        "id": "Shop_2",
        "shopName": "MyShoeStop",
        "shopAddress": {
            "shopNumber": "11A",
            "shopStreet": "South Extension",
            "shopcity": "New Delhi",
            "latitude": "28.5698009",
            "longitude": "77.2195028"
        }
    },
    "Shop_1": {
        "id": "Shop_1",
        "shopName": "MyFashionStop",
        "shopAddress": {
            "shopNumber": "15A",
            "shopStreet": "Green Park",
            "shopcity": "New Delhi",
            "latitude": "28.5584489",
            "longitude": "77.2029376"
        }
    }
}

2- to get a specific shop details":

say: sop with id= Shop_4

Get request: localhost:8081/shops/Shop_4

and the output would be:

{
    "id": "Shop_4",
    "shopName": "MyGameStop",
    "shopAddress": {
        "shopNumber": "209B",
        "shopStreet": "Connaught Place",
        "shopcity": "New Delhi",
        "latitude": "28.6314512",
        "longitude": "77.2166672"
    }
}


3- PUT request to update details about certain shop
the controller method for this activity expects to have Shop object as
a parameter and a shop.id, to look for the shop object whose content
is to be updated.

(we are going to edit details of shop with id= Shop_1)
(we provide a JSON input for newUpdatedShopDetails object and on
headers set contenten-type to application/json)
JSON input(for update you must provide non-null value to key: id, because shop_id is used as key in hashMap for maintaining shop_inventory, see /RetailManagementMVC/src/main/java/com/jmishra/retailService/Service/ShopServiceImpl.java 
Also do share the longitude and latitude information, as well otherwise they would come initialised as null in the output :


  SampleJSON input:
    {
        "id": "Shop_4",
        "shopName": "MyFashionLikesStop",
        "shopAddress": {
            "shopNumber": "209B",
            "shopStreet": "Nehru Place",
            "shopcity": "New Delhi",
            "latitude": "28.6314512", 
            "longitude": "77.2166672"
           
        }
    }


PUT URL: http://localhost:8081/shops/Shop_4

output:

oldShopDetails : 

Shop [id=Shop_4, shopName=MyFashionLikesStop, shopAddress=Address [shopNumber=209B, shopStreet=Nehru Place, shopcity=New Delhi, latitude= null, longitude= null]]

 has changed to 

 newShopDetails: 

Shop [id=Shop_4, shopName=MyFashionLikesStop, shopAddress=Address [shopNumber=209B, shopStreet=Nehru Place, shopcity=New Delhi, latitude= 28.6314512, longitude= 77.2166672]]


4- Add a new Shop object:

Here again the same restriction is followed as was followed in update the shop details request.
For just showing what happens when we do not provide longitude and latitude information in the Shop JSON, these fields of the Address class get initialised as null

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

POST URL: http://localhost:8081/shops

Output(same json object):

{
    "id": "Shop_5",
    "shopName": "MyFashionStop3",
    "shopAddress": {
        "shopNumber": "256A",
        "shopStreet": "Kalu Sarai Market",
        "shopcity": "New Delhi",
        "latitude": null,
        "longitude": null
    }
}

DELETE:
we will remove the shop from inventory with a specific id.
The controller method receives this ID from the URL path itself using
@PathVariable annotation
(we are going to remove a shop object with id= Shop_4

DELETE URL: http://localhost:8081/shops/Shop_4

output:
removedShop details: 

Shop [id=Shop_4, shopName=MyFashionLikesStop, shopAddress=Address [shopNumber=209B, shopStreet=Nehru Place, shopcity=New Delhi, latitude= 28.6314512, longitude= 77.2166672]]


After this request if you run the GetAllShops request:

GET: http://localhost:8081/shops

output(Json array object with Shop object with id ="Shop_4":

{
    "Shop_5": {
        "id": "Shop_5",
        "shopName": "MyFashionStop3",
        "shopAddress": {
            "shopNumber": "256A",
            "shopStreet": "Kalu Sarai Market",
            "shopcity": "New Delhi",
            "latitude": null,
            "longitude": null
        }
    },
    "Shop_3": {
        "id": "Shop_3",
        "shopName": "MyGeekyStop",
        "shopAddress": {
            "shopNumber": "15/26",
            "shopStreet": "Nehru Place",
            "shopcity": "New Delhi",
            "latitude": "28.5503314",
            "longitude": "77.2501893"
        }
    },
    "Shop_2": {
        "id": "Shop_2",
        "shopName": "MyShoeStop",
        "shopAddress": {
            "shopNumber": "11A",
            "shopStreet": "South Extension",
            "shopcity": "New Delhi",
            "latitude": "28.5698009",
            "longitude": "77.2195028"
        }
    },
    "Shop_1": {
        "id": "Shop_1",
        "shopName": "MyFashionStop",
        "shopAddress": {
            "shopNumber": "15A",
            "shopStreet": "Green Park",
            "shopcity": "New Delhi",
            "latitude": "28.5584489",
            "longitude": "77.2029376"
        }
    }
}


I have added the executable jar, which can be found at:

RetailManagementMVC/RetailManagementMVC/build/libs/RetailManagementMVC-0.0.1-SNAPSHOT.jar


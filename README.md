JSON MOCK SERVER

#How to Run
import this api end points to your PostMan and check out the Documentation for the usage of every api.

#PostMan Api Collection
https://www.getpostman.com/collections/a3e876131668e36c484c

#To test these apis ,
- First You need to create authors with unique authorId.
- You can create , update , get ,  delete and filter  authors .
- then you can use any author id to create posts 
- At first the post count for a particular api is 0 , as soon as you create posts post count will increment accordingly.
- you can create , update , get , delete and filter authors. 

#Tech Used  
- JAVA SPRING BOOT for backend dev
- AZURE for Deployment

#Home API Usage 

GET- https://json-web.azurewebsites.net

{
    "posts": [
        {
            "reviews": 1,
            "author": "ankit23",
            "id": 1,
            "title": "Avengers",
            "views": 7
        },
        {
            "reviews": 6,
            "author": "prateek26",
            "id": 2,
            "title": "Avengers",
            "views": 9
        },
        {
            "reviews": 1,
            "author": "prateek26",
            "id": 3,
            "title": "Superman",
            "views": 8
        },
        {
            "reviews": 16,
            "author": "suhas28",
            "id": 4,
            "title": "Superman",
            "views": 61
        },
        {
            "reviews": 0,
            "author": "suhas28",
            "id": 5,
            "title": "Marvel",
            "views": 1
        },
        {
            "reviews": 4,
            "author": "prateek26",
            "id": 6,
            "title": "Marvel",
            "views": 16
        }
    ],
    "authors": [
        {
            "firstName": "Prateek",
            "lastName": "Rai",
            "id": 1,
            "authorId": "prateek26",
            "posts": 3
        },
        {
            "firstName": "Suhas",
            "lastName": "Singh",
            "id": 2,
            "authorId": "suhas28",
            "posts": 2
        },
        {
            "firstName": "Commerce",
            "lastName": "IQ",
            "id": 3,
            "authorId": "ciq",
            "posts": 0
        },
        {
            "firstName": "Ankit",
            "lastName": "Singh",
            "id": 4,
            "authorId": "ankit23",
            "posts": 1
        }
    ]
}

![image](https://user-images.githubusercontent.com/35877862/121785567-26d80d80-cbd8-11eb-8c37-49f985b8848e.png)



#Author Apis Usage 

#Request 
POST - https://json-web.azurewebsites.net/authors

{
    "authorId" : "prateek12",
    "firstName": "Prateek Rai", 
    "lastName" : "Singh"
}
#Response
Author Successfully Added

![image](https://user-images.githubusercontent.com/35877862/121784752-63edd100-cbd3-11eb-8e26-54431f0f29e1.png)

#Request
GET- https://json-web.azurewebsites.net/authors

#Response 
[
    {
        "firstName": "Prateek",
        "lastName": "Rai",
        "id": 1,
        "authorId": "prateek26",
        "posts": 0
    },
    {
        "firstName": "Suhas",
        "lastName": "Singh",
        "id": 2,
        "authorId": "suhas28",
        "posts": 0
    },
    {
        "firstName": "Commerce",
        "lastName": "IQ",
        "id": 3,
        "authorId": "ciq",
        "posts": 0
    },
    {
        "firstName": "Ankit",
        "lastName": "Singh",
        "id": 4,
        "authorId": "ankit23",
        "posts": 0
    }
]
![image](https://user-images.githubusercontent.com/35877862/121784835-e8d8ea80-cbd3-11eb-9784-caf5a8d2579e.png)


#Request

DELETE https://json-web.azurewebsites.net//authors/ankit29

![image](https://user-images.githubusercontent.com/35877862/121784932-846a5b00-cbd4-11eb-8d1c-9b9231970568.png)

Updated Author List

[
    {
        "firstName": "Suhas",
        "lastName": "Singh",
        "id": 1,
        "authorId": "suhas27",
        "posts": 0
    },
    {
        "firstName": "Prateek",
        "lastName": "Rai",
        "id": 2,
        "authorId": "prateek26",
        "posts": 0
    },
    {
        "firstName": "Amit",
        "lastName": "Singh",
        "id": 3,
        "authorId": "amit123",
        "posts": 0
    },
    {
        "firstName": "Ankit",
        "lastName": "Verma",
        "id": 4,
        "authorId": "ankit23",
        "posts": 0
    }
]

![image](https://user-images.githubusercontent.com/35877862/121784986-c85d6000-cbd4-11eb-930e-f06b63158552.png)


#Request
Update Request

Old details of ankit23
![image](https://user-images.githubusercontent.com/35877862/121785011-efb42d00-cbd4-11eb-8da9-2fd3872e424d.png)

PUT - https://json-web.azurewebsites.net/authors/ankit23
{
    "firstName": "Ankit", 
    "lastName" : "Singh"
}

![image](https://user-images.githubusercontent.com/35877862/121785034-107c8280-cbd5-11eb-8b36-38659a03cc48.png)

New Details of ankit23

![image](https://user-images.githubusercontent.com/35877862/121785065-4588d500-cbd5-11eb-8382-8ff7939a40cc.png)


#Some Filters 

GET- https://json-web.azurewebsites.net/authors?q=ank

GET-https://json-web.azurewebsites.net/authors?last_name=rai

![image](https://user-images.githubusercontent.com/35877862/121785097-6a7d4800-cbd5-11eb-81fa-334dabb8486a.png)

![image](https://user-images.githubusercontent.com/35877862/121785127-9ef10400-cbd5-11eb-855c-8ec6112e5ff1.png)


#Posts Apis Usage 

#Requests

POST- https://json-web.azurewebsites.net/posts

{
    "title" : "Superman" ,
    "author":"prateek26" 
}

#Request 

GET- https://json-web.azurewebsites.net/posts

[
    {
        "reviews": 1,
        "author": "ankit23",
        "id": 1,
        "title": "Avengers",
        "views": 7
    },
    {
        "reviews": 6,
        "author": "prateek26",
        "id": 2,
        "title": "Avengers",
        "views": 9
    },
    {
        "reviews": 1,
        "author": "prateek26",
        "id": 3,
        "title": "Superman",
        "views": 8
    },
    {
        "reviews": 16,
        "author": "suhas28",
        "id": 4,
        "title": "Superman",
        "views": 61
    },
    {
        "reviews": 0,
        "author": "suhas28",
        "id": 5,
        "title": "Marvel",
        "views": 1
    },
    {
        "reviews": 4,
        "author": "prateek26",
        "id": 6,
        "title": "Marvel",
        "views": 16
    },
    {
        "reviews": 0,
        "author": "ciq",
        "id": 7,
        "title": "Avengers",
        "views": 41
    }
]


#Request

GET - https://json-web.azurewebsites.net/posts?title=marvel

[
    {
        "reviews": 0,
        "author": "suhas28",
        "id": 5,
        "title": "Marvel",
        "views": 1
    },
    {
        "reviews": 4,
        "author": "prateek26",
        "id": 6,
        "title": "Marvel",
        "views": 16
    }
]
![image](https://user-images.githubusercontent.com/35877862/121785703-f6dd3a00-cbd8-11eb-863a-fe17210a0712.png)


GET - https://json-web.azurewebsites.net/posts?title=avengers&author=prateek

[
    {
        "reviews": 6,
        "author": "prateek26",
        "id": 2,
        "title": "Avengers",
        "views": 9
    }
]
![image](https://user-images.githubusercontent.com/35877862/121785732-1d02da00-cbd9-11eb-8e50-86ffd913497f.png)


GET - https://json-web.azurewebsites.net/posts?sort=views&order=dsc

[
    {
        "reviews": 16,
        "author": "suhas28",
        "id": 4,
        "title": "Superman",
        "views": 61
    },
    {
        "reviews": 0,
        "author": "ciq",
        "id": 7,
        "title": "Avengers",
        "views": 41
    },
    {
        "reviews": 4,
        "author": "prateek26",
        "id": 6,
        "title": "Marvel",
        "views": 16
    },
    {
        "reviews": 6,
        "author": "prateek26",
        "id": 2,
        "title": "Avengers",
        "views": 9
    },
    {
        "reviews": 1,
        "author": "prateek26",
        "id": 3,
        "title": "Superman",
        "views": 8
    },
    {
        "reviews": 1,
        "author": "ankit23",
        "id": 1,
        "title": "Avengers",
        "views": 7
    },
    {
        "reviews": 0,
        "author": "suhas28",
        "id": 5,
        "title": "Marvel",
        "views": 1
    }
]

![image](https://user-images.githubusercontent.com/35877862/121785742-3f94f300-cbd9-11eb-96a4-6876528cf428.png)


DELETE - https://json-web.azurewebsites.net/posts/3


OLD GET Response for Post 
[
    {
        "reviews": 1,
        "author": "ankit23",
        "id": 1,
        "title": "Avengers",
        "views": 7
    },
    {
        "reviews": 1,
        "author": "prateek26",
        "id": 3,
        "title": "Superman",
        "views": 8
    },
    {
        "reviews": 16,
        "author": "suhas28",
        "id": 4,
        "title": "Superman",
        "views": 61
    },
    {
        "reviews": 0,
        "author": "suhas28",
        "id": 5,
        "title": "Marvel",
        "views": 1
    },
    {
        "reviews": 4,
        "author": "prateek26",
        "id": 6,
        "title": "Marvel",
        "views": 16
    },
    {
        "reviews": 0,
        "author": "ciq",
        "id": 7,
        "title": "Avengers",
        "views": 41
    }
]
New GET Response for post

[
    {
        "reviews": 1,
        "author": "ankit23",
        "id": 1,
        "title": "Avengers",
        "views": 7
    },
    {
        "reviews": 16,
        "author": "suhas28",
        "id": 4,
        "title": "Superman",
        "views": 61
    },
    {
        "reviews": 0,
        "author": "suhas28",
        "id": 5,
        "title": "Marvel",
        "views": 1
    },
    {
        "reviews": 4,
        "author": "prateek26",
        "id": 6,
        "title": "Marvel",
        "views": 16
    },
    {
        "reviews": 0,
        "author": "ciq",
        "id": 7,
        "title": "Avengers",
        "views": 41
    }
]

UPDATE - 

OLD POST of ciq

https://json-web.azurewebsites.net/posts?author=ciq
[
    {
        "reviews": 0,
        "author": "ciq",
        "id": 7,
        "title": "Avengers",
        "views": 41
    }
]

PATCH  - https://json-web.azurewebsites.net/posts/7
{
   "title": "Marvel",
   "author":"ciq"

}

New POSt of ciq after update 
[
    {
        "reviews": 0,
        "author": "ciq",
        "id": 7,
        "title": "Marvel",
        "views": 41
    }
]





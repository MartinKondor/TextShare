import App from "./App";

const Home  = [
    {
        "id": 1,
        "userId": 52,
        "timestamp": "1701297952",
        "content": "Here is the oldest message you can get.",
        "user": {
            "id": 52,
            "username": "test_new",
            "email": "test_new@test.test",
            "password": "58a3179a735ac90d5774143357d101a9",
            "birthdate": "2002-02-02",
            "profileImgUrl": null
        },
        "upvotes": [
            {
                "id": 52,
                "userId": 52,
                "textId": 1,
                "user": {
                    "id": 52,
                    "username": "test_new",
                    "email": "test_new@test.test",
                    "password": "58a3179a735ac90d5774143357d101a9",
                    "birthdate": "2002-02-02",
                    "profileImgUrl": null
                }
            }
        ],
        "downvotes": []
    },
    {
        "id": 2,
        "userId": 52,
        "timestamp": "1701360833",
        "content": "Here is the newest fresh message",
        "user": {
            "id": 52,
            "username": "test_new",
            "email": "test_new@test.test",
            "password": "58a3179a735ac90d5774143357d101a9",
            "birthdate": "2002-02-02",
            "profileImgUrl": null
        },
        "upvotes": [],
        "downvotes": []
    }
];

export default Home;

Android Dashboard App

This is a simple Android app that demonstrates the use of API integration, user interface design, and Android development best practices. The app consists of a Login screen, a Dashboard screen (that displays data), and a Details screen (that shows detailed information).

Requirements

Before running this app, make sure you have the following:

- Android Studio (latest version recommended).
- Java JDK (version 8 or higher).
- Android Emulator or a physical device for testing.
- An internet connection to fetch data from the API.

 API Integration

This app integrates with the `vu-nit3213-api` to authenticate users and fetch data. 

 API Endpoints:
1.	Login Endpoint:

   - URL: `/footscray/auth` (use the correct endpoint based on your class location: `/sydney/auth`, `/br/auth`)
   - Method: POST
   - Request Body:
     ```json
     {
       "username": "YourFirstName",
       "password": "YourStudentID" (without the "s" character)
     }
     ```
   - Successful Response:
     ```json
     {
       "keypass": "topicName"
     }
     ```

2. Dashboard Endpoint:

   - URL: `/dashboard/{keypass}`
   - Method: GET
   - Successful Response:
     ```json
     {
       "entities": [
        {
        "property1": "value1",
        "property2": "value2",
        "description": "Detailed description"
        },
      ],
       "entityTotal": 7
     }
     ```

 Getting Started

 1. Clone the Repository

Clone this repository to your local machine using the following command:

```bash
git clone https://github.com/your-username/my-assessment-app.git
```

 2. Open the Project in Android Studio

- Launch Android Studio.
- Select Open an existing Android Studio project.
- Navigate to the directory where you cloned the repository and select the project folder.

 3. Set Up Your API Key and Endpoint

- Ensure that the app uses the correct API endpoint based on your class location.
- Update the `RetrofitClient` to use the correct base URL for the API if necessary.

 4. Build the Project

- In Android Studio, go to Build ‚Make Project.
- Ensure there are no errors and the app builds successfully.

 5. Run the App

- Connect an Android device or start an Android Emulator.
- Click on the Run button (green play button) in Android Studio.
- The app will install on the connected device/emulator.
- Once the app is running, follow the on-screen instructions to log in and view the dashboard data.

 Project Structure

Here‚ is an overview of the project structure:

- MainActivity.kt: Contains the logic for the login screen.
- DashboardActivity.kt: Contains the logic for the dashboard screen where course data is displayed.
- DetailsActivity.kt: Contains the logic for the detailed view of a selected course.
- RetrofitClient.kt: Contains the Retrofit API client for handling network requests.
- Entity.kt: Defines the data model for a entity.
- activity_main.xml: The layout for the login screen.
- activity_dashboard.xml: The layout for the dashboard screen.
- activity_details.xml: The layout for the details screen.

 Troubleshooting

1. Error: "Keypass not found"

If you see this message, ensure that:

- The correct `keypass` is being passed in the login response.
- You‚ are using the correct login credentials (first name and student ID without the "s").

 2. Error: "No internet connection"

Ensure that your device or emulator has an active internet connection.

 3. Error: "Failed to load dashboard"

If you are seeing this error:

- Double-check that your API URL and keypass are correct.
- Ensure that the Retrofit API client is configured properly

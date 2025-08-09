# PostFetcherIce

An Android app demonstrating how to fetch data from a REST API using Retrofit with query parameters, display the data in a fragment, and show the raw JSON data on a separate screen.

---

## Table of Contents

- [Features](#features)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Dependencies](#dependencies)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- Fetches post data from the [JSONPlaceholder](https://jsonplaceholder.typicode.com/posts?userId=1&id=5) API using Retrofit with query parameters.
- Displays the post’s title and body inside a dedicated fragment (`PostFragment3`).
- Provides a button to generate and view the JSON representation of the displayed data.
- Opens a new activity (`JsonDisplayActivity`) to show the formatted JSON string.
- Handles API response errors gracefully with proper user feedback.
- Written entirely in Kotlin following clean architecture practices.

---


### Screenshots


| PostFragment3 (Post Display) | JsonDisplayActivity (Raw JSON) |
|------------------------------|-------------------------------|
| (<img width="1920" height="1080" alt="Screenshot (189)" src="https://github.com/user-attachments/assets/9850811b-c7d5-440b-b423-816ae2eec8fe" />)
) (<img width="1920" height="1080" alt="Screenshot (190)" src="https://github.com/user-attachments/assets/fb7f2d2f-becc-4f4f-8cf6-8ce7def91730" />)
|

---


### Prerequisites

- Android Studio Bumblebee or newer
- Android SDK installed
- A device or emulator running Android API level 21 or higher
- Internet connection for API calls

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/Rique14/PostFetcherIce.git
   [cd PostFetcherIce](https://github.com/Rique14/PostFetcherIce/tree/master)

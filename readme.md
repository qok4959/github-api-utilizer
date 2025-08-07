# GitHub API Utilizer

A Spring Boot application that integrates with the GitHub API to retrieve repository and branch information.

## Prerequisites

- Java 21
- GitHub Personal Access Token

## Configuration

### GitHub API Token

This application requires a GitHub Personal Access Token to access the GitHub API. You must provide this token as a VM
option when running the application.

#### Please follow the official GitHub doc for creating Personal Access Token -> https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/managing-your-personal-access-tokens#creating-a-fine-grained-personal-access-token:~:text=credentials%20secure.-,Creating%20a%20fine%2Dgrained%20personal%20access%20token,-Note

### Setting up VM Options

**Option 1: IntelliJ IDEA**

1. Go to **Run** → **Edit Configurations**
2. Select your Spring Boot run configuration (or create one if it doesn't exist)
3. In the **VM options** field, add:
   ```
   -Dgithub.api.token=your_github_token_here
   ```
   Replace `your_github_token_here` with the actual token you generated above.

4. Click **Apply** and **OK**
5. Run the application using this configuration

**Example VM Options:**

```
-Dgithub.api.token=ghp_1234567890abcdefghijklmnopqrstuvwxyz1234
```

**Option 2: Command Line**
When running the application via Maven, you can pass the token as a system property:

```bash
mvn spring-boot:run -Dgithub.api.token=your_github_token_here
```

**Option 3: Environment Variables (Alternative)**
You can also set the token as an environment variable:

```bash
export GITHUB_API_TOKEN=your_github_token_here
```

Then update your `application.properties` to use the environment variable:

```properties
github.api.token=${GITHUB_API_TOKEN:none}
```

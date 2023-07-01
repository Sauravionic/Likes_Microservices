---


---

<h1 id="api-documentation">API Documentation!</h1>
<p>Hi! I’m <strong>Saurav Srivastava</strong>. This is a likes microservice application built and configured in Spring boot using MySQL, Caching and docker.</p>
<h1 id="overview">Overview</h1>
<p>This API provides functionality for managing <strong>likes on content</strong>.</p>
<h2 id="base-url">Base URL</h2>
<p>The base URL for this API is: <code>http://localhost:9090/api/v1/likes</code></p>
<h2 id="endpoints">Endpoints</h2>
<h4 id="store-like">Store Like</h4>
<ul>
<li>
<p><strong>Endpoint:</strong> <code>/</code></p>
</li>
<li>
<p><strong>Method:</strong> <code>POST</code></p>
</li>
<li>
<p><strong>Description:</strong> Stores a like event for a user on a specific content.</p>
</li>
<li>
<p><strong>Request Body:</strong> Json<br>
<code>{ "userId": "string", "contentId": "string" }</code></p>
</li>
<li>
<p><strong>Responses:</strong></p>
<ul>
<li><code>200 OK</code> - Like event stored successfully.</li>
<li><code>400 Bad Request</code> - Invalid request body.</li>
<li><code>500 Internal Server Error</code> - An error occurred while processing the request.</li>
</ul>
</li>
</ul>
<h4 id="check-liked">Check Liked</h4>
<ul>
<li><strong>Endpoint:</strong> <code>/check</code></li>
<li><strong>Method:</strong> <code>GET</code></li>
<li><strong>Description:</strong> Checks if a user has liked a specific content.</li>
<li><strong>Query Parameters:</strong>
<ul>
<li><code>userId</code> - The ID of the user (required).</li>
<li><code>contentId</code> - The ID of the content (required).</li>
</ul>
</li>
<li><strong>Responses:</strong>
<ul>
<li><code>200 OK</code> - User has liked the content.</li>
<li><code>404 Not Found</code> - User has not liked the content.</li>
<li><code>500 Internal Server Error</code> - An error occurred while processing the request.</li>
</ul>
</li>
</ul>
<h4 id="get-total-likes">Get Total Likes</h4>
<ul>
<li><strong>Endpoint:</strong> <code>/total</code></li>
<li><strong>Method:</strong> <code>GET</code></li>
<li><strong>Description:</strong> Retrieves the total number of likes for a specific content.</li>
<li><strong>Query Parameters:</strong>
<ul>
<li><code>contentId</code> - The ID of the content (required).</li>
</ul>
</li>
<li><strong>Responses:</strong>
<ul>
<li><code>200 OK</code> - Total likes retrieved successfully.</li>
<li><code>404 Not Found</code> - Content not found.</li>
<li><code>500 Internal Server Error</code> - An error occurred while processing the request.</li>
</ul>
</li>
</ul>
<h2 id="code-documentation-main">Code Documentation (main)</h2>
<h3 id="packages">Packages</h3>
<ul>
<li><code>com.ionic.Likes_Microservices</code>: Root package.</li>
<li><code>com.ionic.Likes_Microservices.Controller</code>: Contains the API controllers.</li>
<li><code>com.ionic.Likes_Microservices.Service</code>: Contains the service classes.</li>
<li><code>com.ionic.Likes_Microservices.Model</code>: Contains the data models.</li>
<li><code>com.ionic.Likes_Microservices.Repository</code>: Contains the repositories.</li>
<li><code>com.ionic.Likes_Microservices.Config</code>: Contains the caching configuration.</li>
</ul>
<h3 id="classes">Classes</h3>
<h4 id="likescontroller">LikesController</h4>
<ul>
<li><strong>Description:</strong> Controller class for handling like-related API requests.</li>
<li><strong>Methods:</strong>
<ul>
<li><code>storeLike</code>: Handles the <code>/</code> POST request for storing a like event.</li>
<li><code>checkLiked</code>: Handles the <code>/check</code> GET request for checking if a user has liked a content.</li>
<li><code>getTotalLikes</code>: Handles the <code>/total</code> GET request for retrieving the total likes for a content.</li>
</ul>
</li>
</ul>
<h4 id="likesservice">LikesService</h4>
<ul>
<li><strong>Description:</strong> Service interface for handling like-related operations.</li>
<li><strong>Methods:</strong>
<ul>
<li><code>storeLike</code>: Stores a like event for a user on a specific content.</li>
<li><code>checkLiked</code>: Checks if a user has liked a specific content.</li>
<li><code>getTotalLikes</code>: Retrieves the total number of likes for a specific content.</li>
<li><code>sendPushNotification</code>: Sends a push notification to a user.</li>
</ul>
</li>
</ul>
<h4 id="likesserviceimpl">LikesServiceImpl</h4>
<ul>
<li><strong>Description:</strong> Service implementation class for handling like-related operations.</li>
<li><strong>Methods:</strong>
<ul>
<li><code>storeLike</code>: Stores a like event for a user on a specific content.</li>
<li><code>checkLiked</code>: Checks if a user has liked a specific content.</li>
<li><code>getTotalLikes</code>: Retrieves the total number of likes for a specific content.</li>
<li><code>sendPushNotification</code>: Sends a push notification to a user.</li>
</ul>
</li>
</ul>
<h4 id="likerequestdto">LikeRequestDTO</h4>
<ul>
<li><strong>Description:</strong> Data transfer object for storing like request information.</li>
<li><strong>Properties:</strong>
<ul>
<li><code>userId</code>: The ID of the user.</li>
<li><code>contentId</code>: The ID of the content.</li>
</ul>
</li>
</ul>
<h4 id="likeresponsedto">LikeResponseDTO</h4>
<ul>
<li><strong>Description:</strong> Data transfer object for storing like response information.</li>
<li><strong>Properties:</strong>
<ul>
<li><code>liked</code>: Indicates if the user has liked the content (boolean).</li>
</ul>
</li>
</ul>
<h4 id="likecountdto">LikeCountDTO</h4>
<ul>
<li><strong>Description:</strong> Data transfer object for storing like count information.</li>
<li><strong>Properties:</strong>
<ul>
<li><code>totalLikes</code>: The total number of likes for a content.</li>
</ul>
</li>
</ul>
<h4 id="likerepository">LikeRepository</h4>
<ul>
<li><strong>Description:</strong> Repository interface for interacting with the database.</li>
<li><strong>Methods:</strong>
<ul>
<li><code>save</code>: Saves a like event to the database.</li>
<li><code>existsByUserIdAndContentId</code>: Retrieves a boolean value for like event by user ID and content ID.</li>
<li><code>countByContentId</code>: counts the number of users who liked the content.</li>
</ul>
</li>
</ul>
<h4 id="cacheconfiguration">CacheConfiguration</h4>
<ul>
<li><strong>Description:</strong> Configuration class for enabling caching in the application.</li>
<li><strong>Methods:</strong>
<ul>
<li><code>cacheManager</code>: Configures the cache manager.</li>
<li><strong>Explaination:</strong> Caching is applied on all 3 endpoints. Therefore for get requests, the cache will be checked first for the response. If the request to cache is successful then no request to the Database will be made. Else if the request does not exists in the cache then the request to the Database is made. This decreases the response time of API significantly.</li>
</ul>
</li>
</ul>
<h1 id="application-run">Application Run</h1>
<p>This document provides step-by-step instructions on how to run your application and SQL container on another system using <strong>Docker</strong>.</p>
<h2 id="prerequisites">Prerequisites</h2>
<p>Before proceeding with the deployment, ensure that the following prerequisites are met:</p>
<ul>
<li>Docker is installed on the target system.</li>
</ul>
<h2 id="deployment-steps">Deployment Steps</h2>
<h3 id="step-1-pull-docker-sql-image">Step 1: Pull Docker SQL Image</h3>
<ol>
<li>
<p>Open a terminal or command prompt on the target system.</p>
</li>
<li>
<p>Run the following commands to pull the Docker image:</p>
<pre><code>docker pull mysql
</code></pre>
</li>
</ol>
<h3 id="step-2-pull-application-image">Step 2: Pull Application Image</h3>
<ol>
<li>
<p>Run the following commands to pull the Application Docker image</p>
<pre><code>docker pull sauravionic/likes-app:app
</code></pre>
<p>Alternatively, if you don’t want to pull from docker. You can build the docker image from the application files.<br>
Open the application in an IDE and run the following command in the terminal of you project folder</p>
<pre><code>docker build -t app .
</code></pre>
</li>
</ol>
<h3 id="step-3-create-a-docker-network">Step 3: Create a Docker Network</h3>
<ol>
<li>
<p>Create a Docker network to allow communication between the application and SQL containers:</p>
<pre><code>docker network create likes-network
</code></pre>
</li>
</ol>
<h3 id="step-4-run-mysql-container">Step 4: Run MySQL Container</h3>
<ol>
<li>
<p>Run your MySQL container with environment variables of password and database name.</p>
<pre><code>docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MY_SQL_DATABASE=likesdb mysql:latest
</code></pre>
</li>
</ol>
<h4 id="note-optional">NOTE (OPTIONAL)</h4>
<p>**:- MySQL Container is up and running. You can check the database if you want. There are 2 ways to check the database.</p>
<p><em><strong>Through MySQL Workbench</strong></em> -&gt; Simply open SQL workbench and click on + sign. Change the port name to 3307 and provide password = root</p>
<p><em><strong>Through Command Line / Terminal</strong></em> -&gt; Run this command -&gt;</p>
<pre><code>docker container ls
</code></pre>
<p>Now copy the container id of mysqldb container and run the following command</p>
<pre><code>docker exec -it &lt;put your container-id here&gt; bash
</code></pre>
<p>Now in bash write the following command</p>
<pre><code>bash-4.4# mysql -u root -p
</code></pre>
<p>password: root</p>
<pre><code>mysql:-&gt; show databases
</code></pre>
<h3 id="step-5-connect-mysql-container-to-network">Step 5: Connect MySQL Container to Network</h3>
<pre><code>docker network connect likes-network mysqldb
</code></pre>
<p>MySQL Container is now configured on the network <code>likes-network</code></p>
<h3 id="step-6-run-your-application-on-the-network">Step 6: Run Your Application on the Network</h3>
<ol>
<li>
<p>Run your application container, linking it to the SQL container and specifying the necessary environment variables and ports.</p>
<pre><code>docker run -p 9090:8080 --name app --net likes-network -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PORT=3306 app`
</code></pre>
</li>
</ol>
<h3 id="step-7-verify-the-setup">Step 7: Verify the Setup</h3>
<ol>
<li>
<p>Check the status of your containers by running the following command</p>
<pre><code>docker ps
</code></pre>
</li>
</ol>
<h3 id="step-8-access-your-application">Step 8: Access Your Application</h3>
<ol>
<li>Open postman or similar client on the target system.</li>
<li>Enter <code>http://localhost:9090/api/v1/likes</code> in the address bar</li>
<li>If everything is set up correctly, you should be able to access and interact with your application.</li>
</ol>
<h1 id="application-testing">Application Testing</h1>
<h2 id="test-classes">Test Classes</h2>
<p>The application testing includes the following test classes:</p>
<ol>
<li>
<p><strong>LikesServiceIMPLTest</strong>: This class tests the <code>LikesServiceIMPL</code> class, which is responsible for handling like-related operations.</p>
</li>
<li>
<p><strong>LikesRepoTest</strong>: This class tests the <code>LikesRepo</code> class, which is responsible for database operations related to likes.</p>
</li>
<li>
<p><strong>LikesControllerTest</strong>: This class tests the <code>LikesController</code> class, which handles HTTP requests and responses for like-related endpoints.</p>
</li>
</ol>
<h2 id="likesserviceimpltest">LikesServiceIMPLTest</h2>
<p>The <code>LikesServiceIMPLTest</code> class tests the functionalities of the <code>LikesServiceIMPL</code> class. The LikesRepo Interface has been mocked by MOCKTIO</p>
<h3 id="test-methods">Test Methods</h3>
<ol>
<li>
<p><strong>storeLike</strong>: Tests the <code>storeLike</code> method of the <code>LikesServiceIMPL</code> class. It verifies if the method returns the expected response when saving a like.</p>
</li>
<li>
<p><strong>checkLiked</strong>: Tests the <code>checkLiked</code> method of the <code>LikesServiceIMPL</code> class. It verifies if the method returns the expected response when checking if a like exists.</p>
</li>
<li>
<p><strong>getTotalLikes</strong>: Tests the <code>getTotalLikes</code> method of the <code>LikesServiceIMPL</code> class. It verifies if the method returns the expected total number of likes for a content.</p>
</li>
</ol>
<h2 id="likesrepotest">LikesRepoTest</h2>
<p>The <code>LikesRepoTest</code> class tests the functionalities of the <code>LikesRepo</code> class.</p>
<h3 id="test-methods-1">Test Methods</h3>
<ol>
<li>
<p><strong>existsByUserIdAndContentId</strong>: Tests the <code>existsByUserIdAndContentId</code> method of the <code>LikesRepo</code> class. It verifies if the method returns the expected response when checking if a like exists for a specific user and content.</p>
</li>
<li>
<p><strong>countByContentId</strong>: Tests the <code>countByContentId</code> method of the <code>LikesRepo</code> class. It verifies if the method returns the expected total number of likes for a content.</p>
</li>
</ol>
<h2 id="likescontrollertest">LikesControllerTest</h2>
<p>The <code>LikesControllerTest</code> class tests the functionalities of the <code>LikesController</code> class. LikeService Interface has been Mocked by MOCKTIO</p>
<h3 id="test-methods-2">Test Methods</h3>
<ol>
<li>
<p><strong>storeLike</strong>: Tests the <code>storeLike</code> endpoint of the <code>LikesController</code> class. It verifies if the endpoint returns the expected response when storing a like.</p>
</li>
<li>
<p><strong>checkLiked</strong>: Tests the <code>checkLiked</code> endpoint of the <code>LikesController</code> class. It verifies if the endpoint returns the expected response when checking if a like exists.</p>
</li>
<li>
<p><strong>getTotalLikes</strong>: Tests the <code>getTotalLikes</code> endpoint of the <code>LikesController</code> class. It verifies if the endpoint returns the expected total number of likes for a content.</p>
</li>
</ol>
<h2 id="running-the-tests">Running the Tests</h2>
<p>To run the tests for the Likes Microservices application, follow the steps below:</p>
<ol>
<li>
<p>Ensure that the application and its dependencies are properly set up and configured.</p>
</li>
<li>
<p>Open the testing class in an integrated development environment (IDE) or use a build tool such as Maven or Gradle to run the tests.</p>
</li>
<li>
<p>Execute the test methods individually or run the entire test class, depending on your testing requirements.</p>
</li>
<li>
<p>Monitor the test execution and check the test results to ensure that all tests pass successfully.</p>
</li>
</ol>
<h2 id="file-links">File Links</h2>
<ul>
<li><a href="https://drive.google.com/drive/folders/1pOF_Y4cJiHPb_h8GVl9o9vzXjHEfewws?usp=sharing">Google Drive (Files)</a></li>
<li><a href="https://github.com/Sauravionic/Likes_Microservices">Github</a></li>
<li><a href="https://hub.docker.com/repository/docker/sauravionic/likes-app/general">Docker</a></li>
</ul>
<h2 id="extra">Extra</h2>
<p>If you decide to run the files locally. Please use <code>mvn install</code> command.</p>
<p>**</p>
<h1 id="conclusion">Conclusion</h1>
<p><strong>Author</strong>: Saurav Srivastava<br>
<strong>Version</strong>: v1<br>
<strong>Date</strong>: 01-07-2023</p>


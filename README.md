# Socket Programming Workshop

Welcome to the Java Socket Programming & IO Workshop!
In this hands-on session, you'll explore practical examples using core Java concepts such as sockets, streams, buffering, and object serialization. You'll implement real-time communication, understand IO efficiency, and work with object data transfer between clients and servers.

## 🗂️ Project Structure
This workshop includes the following examples:

1. Group Chat (Multi-Client Chatroom)

2. Buffered vs Unbuffered IO Comparison

3. Object Stream Communication

4. 🧠 Final Assignment: Account Manager (with TODOs)

Each project is organized in its own package and highlights key Java concepts.

## 1. 💬 Group Chat
   A multi-client chat application using Java sockets and multi-threading. It allows multiple clients to connect to a server and chat with each other in real-time.

### 🔧 Technologies Used
- Java Sockets (ServerSocket, Socket)

- Data Streams (DataInputStream, DataOutputStream)

- Multi-threading

### 📁 Files
- `Server.java`: Manages client connections and broadcasts messages.

- `ClientHandler.java`: Handles communication with each client in a separate thread.

- `Client.java`: Connects to the server and sends/receives messages.

Type messages in the client terminal to broadcast to all connected clients. (Type /quit to leave the chat.)

### ✅ Concepts Covered
- `ServerSocket`, `Socket`

- Multi-threaded server (each client handled in a thread)

- `DataInputStream`, `DataOutputStream`

- Real-time communication and message broadcasting

## 2. ⚡ Buffered vs Unbuffered I/O
   Benchmark comparing file copy performance using buffered and unbuffered streams.

### ✅ Concepts Covered
- `FileInputStream` vs `BufferedInputStream`

- Byte stream handling

- Performance measurement with `System.nanoTime()`

### 📁 Files
- `Gen.java` – Generates a test file (file.dat)

- `FileCopyBenchmark.java` – Measures copy speed with and without buffering

## 3. 🧳 Object Stream
   A simple client-server system where Java objects are sent over the network.

### ✅ Concepts Covered
- `ObjectOutputStream`, `ObjectInputStream`

- Serializable objects

- Transmitting full Java objects

### 📁 Files
- `Person.java`

- `Server.java`

- `Client.java`

## 4. 🧠 Account Manager
   Design a client-server system to manage user sign-up and login with serialization and proper account storage.

### 🏗️ What’s Provided
- Serializable Account class

- Pre-built `Client.java` UI with input prompts

- Multithreaded `Server.java` setup

- Socket + object stream connections

### ✅ Your Tasks
- Hash the Password: Use a hashing algorithm (e.g., SHA-256) to store passwords securely. Replace the "HASHED_PASSWORD" placeholder.

- Sign-up Logic

- Serialize and send the Account object from client to server.

- Store new accounts on the server in a list or file.

- Login Logic: Validate the credentials against stored accounts on the server and Return success/failure message to the client.

- Handle Clients in handleClient()

- Implement server-side request handling based on client choice.

### 🧪 Bonus
- Prevent duplicate usernames

- Save/load accounts from disk or database

- Use JavaFX for UI


### 📁 Directory: Workshop.AccountManager
- `Account.java`

- `Client.java` (with input and TODOs)

- `Server.java` (with multithreaded handler and TODO)

### 🔁 Example Flow
```
--- Account Manager ---
1. Sign up
2. Log in
3. Exit
```

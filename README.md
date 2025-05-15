# Angkringan Si Meng

**Theme**: You run a pet-themed café where customers are pets (cats, dogs, and other animals). Your goal is to take orders, serve food, and keep the animals happy while managing the cafe efficiently. Think of it like a combination of **Diner Dash** (restaurant management) and **Cats** (virtual pet management).

---

## Key Features:
1. **Multiple pet customers** (cats, dogs, etc.) with different needs and preferences.
2. **Food orders** that you must prepare and deliver to the pets.
3. **Managing a queue of pets** waiting for service.
4. **Inventory management** for the food items you need to prepare.
5. **Upgrades** for your café and pet care.

---

## Data Structures and Their Roles:

### 1. **List** – **Pet Orders & Inventory Management**
- **Pet Orders**: Store the list of food items ordered by the pets.
  - Each pet order could be a list of food items, and you'll need to serve them in the correct order.
- **Inventory**: Use a list to manage available food ingredients (e.g., catnip, kibble, treats).
  - When an item is used to prepare food, update the list by removing that item.
  
### 2. **Stack** – **Undo/Redo Actions & Order Prep**
- **Undo/Redo**: If the player accidentally serves the wrong food or makes a mistake, the stack can hold previous actions for undoing mistakes (e.g., wrong food served to a cat).
- **Order Prep**: Each order might require multiple actions (e.g., prep ingredients, cook). You could use a stack to track actions during food prep, allowing players to reverse or retry certain steps.

### 3. **Queue** – **Serving Customers (Pets)**
- **Queue for Pet Orders**: When pets enter the café, their orders are added to a queue. You need to serve them in the order they arrive (like a queue of customers).
- **Pet Actions**: Use a queue to manage when pets need to be served, ensuring that they are served in the order they arrive.

### 4. **Set** – **Unique Pet and Food Types**
- **Track Unique Pets and Food Types**: Use a set to ensure no duplicate food or pet orders are taken for the same pet. For example, a specific pet might only want certain food, so using a set can prevent serving the same food to multiple pets that prefer it.
- **Visited Pets**: A set can store pets that have visited the café before, allowing for tracking of returning customers.

### 5. **Map** – **Pet Data and Café Inventory**
- **Pet Data**: Map each pet’s ID to their preferences (what food they like or dislike, how patient they are, etc.). This could be a map of pet types to their behaviors and preferences.
- **Food Inventory**: Map each type of food to its quantity (how much of each ingredient you have left). This allows you to manage your inventory efficiently and know when to restock.
- **Customer Tips**: Map the type of pet to how much they will tip you based on their satisfaction level (happier pets give better tips).

### 6. **Tree** – **Café Upgrades**
- **Café Upgrade Tree**: Organize upgrades to the café as a tree. For example:
  - Root: Base level café
  - Branches: Different types of upgrades like faster cooking stations, better food items, or more pet-friendly decorations.
  - Leaves: Specific upgrades such as a new menu item or upgraded furniture to increase pet happiness.
- **Order Priority**: You could also represent the priority of orders (e.g., pets that are hungrier or more impatient could be at the top of the tree).

### 7. **Binary Tree** – **Decision Tree for Pet Preferences**
- **Pet Behavior**: Use a binary tree to represent a pet’s decision-making process. For instance, some pets may prefer wet food vs. dry food, and each pet can have a binary decision tree to track their preferences.
- **Sorting Pet Orders**: You could use a binary search tree to sort pet orders by urgency or food preference. For example, if the pet prefers treats over meals, treat orders might get a higher priority in the game.

---

## How the Game Works:
1. **Pet Arrival**:
   - Pets enter the café randomly, with each pet having different preferences (e.g., one likes tuna, another likes catnip).
   - These pets are added to a queue to be served in order of their arrival.

2. **Order Taking**:
   - You take the pet’s order and check the **Map** for their preferences. If you have the food item in your **Inventory List**, you start preparing it.
   - Use a **Set** to ensure no duplicate food orders are taken for the same pet.

3. **Food Preparation**:
   - For each pet, the food is prepared by interacting with the **Inventory** (a **List**). If you run out of ingredients, you can **Map** each food to its quantity and restock if needed.
   - **Stack** allows you to undo any mistakes made while preparing the food.

4. **Serving**:
   - Once the food is prepared, serve it to the pet in the correct order based on the **Queue**.
   - Each pet may leave a tip based on how happy they are, which you track with a **Map**.

5. **Upgrades**:
   - As you progress in the game, you can **Upgrade** your café. These upgrades are represented by a **Tree** structure, where each upgrade is a branch.
   - The more customers you serve, the better the upgrades you can afford, such as faster cooking or more inventory slots.

6. **End of Day**:
   - At the end of the day, you can review your performance and tips collected, perhaps unlocking new pets or food items for the next day.
   - A **Binary Tree** could be used to represent different difficulty levels or customer types, making the game progressively more challenging.

---

## Additional Game Elements:
- **Pet Happiness**: Pet satisfaction is tracked with a **Map**, which includes factors like wait time and food quality.
- **Time Management**: The game will likely include a time-based mechanic where you need to serve pets as quickly as possible. **Queues** and **Stacks** help keep track of these tasks.
- **Multiple Pet Types**: Introduce various pet types with unique needs, making it more challenging to juggle orders. You can use the **Map** to track these pet types and their likes/dislikes.
- **Events and Special Pets**: Random events (like special pets visiting your café) could be represented using a **Tree** structure that adds layers of decision-making and challenges to the game.

---

## Technical Details:
- **Swing 2D**: For the interface, you can create a grid layout for your café, where each pet sits at a table. Pet movements, order taking, food preparation, and serving can be animated using Swing's `Graphics` and `Timer` classes.
- You can use **Swing Components** like `JButton`, `JPanel`, `JLabel`, and `JProgressBar` to represent interactive elements such as food preparation or pet happiness.
- **Event Listeners** will handle user interactions like taking orders, serving food, and upgrading the café.

---

## Summary:
This game would be a great blend of strategy, time management, and cute pet interactions, and using all these data structures will make it more dynamic and interesting. By applying **lists, queues, stacks, sets, maps, trees,** and **binary trees**, you can build an engaging and functional game while learning how to manage complex systems and data.

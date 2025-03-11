# My Personal Project

## Dream Garage

<h3>Project Introduction</h3>

<p align="justify">
Every boy must have a <b>Dream Garage</b> in his mind. The <b>Dream Garage</b> will allow collector to easily manage their car collection by adding and removing cars. However, the cooler thing is that you can use the smart generator to generate a garage which is filtered by the range of year or price, this will make you find your target cars faster. Moreover, the garage will be automatically saved in your collection as a record, so that you can find it easily whenever you want. Also, it's free to remove the garages combination if you no longer need it.

The application are for all car lovers, who are owning lots of cars or will own lots of cars. It's a easy using management tool as well as a tool for recording the dream cars.

Personally, this project interests me because I am a *car lover* dreaming of being an amateur racer, and the project will bring me a step closer to my dream.

<h3>User Stories</h3>

- As a user, I want to be able to add a car to my collection
- As a user, I want to be able to view all cars/garages in my collection
- As a user, I want to be able to remove a car/garage from my collection
- As a user, I want to be able to generate a garage by giving the range of the price/year of the car
- As a user, I want to be able to save my cars/garages to my collection
- As a user, I want to be able to load my previous saved cars/garages from my collection

<h3>Instructions for End User</h3>

- You can add cars' information into your collection by clicking the <b>"Add car"</b> button.
- You can view all cars in your collection by clicking the <b>"View cars"</b> button on the left side of the panel, by clicking the row which has all information of that car, you can also use the <b>"Remove selected car"</b> button at the bottom of the panel to remove the car.
- You can view all garages in your collection by clicking the <b>"View garages"</b> button on the left side of the panel, by clicking the row which has all information of that garage, you can click the <b>"View selected garage"</b> to check all cars contained in that garage.You can also use the <b>"Remove selected garage"</b> button at the bottom of the panel to remove the garage.
- You can use the smart garage generator by clicking the <b>"Smart Generator"</b> button on the left side of the panel, by clicking the row which has all information of that garage, you can generate a garage by giving the range of the price/year of the car
- You can locate my visual component by setting up the cover picture of the panel, and as long as you save it, next time you open the software you will see it as your cover
- You can save the state of your collection by clicking the menu button on the left head of the panel and rename and save your collection as a Json file
- You can reload the state of your collection by clicking the menu button on the left head of the panel and choose a Json file on your computer and load it as your collection


<h3>Phase 4: Task 2</h3>
The sample of logging events:

"---------------------------------------------"  
Events logged during this session:  
Tue Nov 26 10:21:48 PST 2024. 
1 was added to the collection    
"---------------------------------------------"  
Tue Nov 26 10:21:51 PST 2024. 
1 was removed from the collection   
"---------------------------------------------"  

<h3>Phase 4: Task3</h3>

- If I had more time to refactor my project and improve my design, I would start by splitting the current GUI class into multiple subclasses before adding all the elements to the main GUI class. Currently, my GarageApp class has over 550 lines, which makes it difficult for code readers to quickly understand my design ideas. In the future I could create more interfaces or abstract classes to simplify my GUI with the right logic.

- In addition, at the beginning of the semester I wasn't very familiar with the software design process and didn't know the relationship between the model and the ui, so I added a lot of functionality to the ui that should have been implemented in the model. As a result, my ui was not just involved in interactive activities with the user, and in the future I can integrate all of this functionality into the model's class to make the logic clearer.

# Dream-Garage
# Dream-Garage

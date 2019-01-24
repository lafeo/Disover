Introduction
Brick Breaker is a game which has been around since the early days of computer gaming, from the days of the PAC-MAN and PONG, Brick-breaker made it’s way up through the Atari Game Universe under the name “Breakout” where a launcher would be shooting small loads of ammunition to collect points.
Later the most famous and the most publicly reached version of game was introduced by Blackberry a Canadian Mobile Phone company.
Similarly I thought that such games who hold value in the hearts of those computerphiles from the 90s deserve to see new versions of their game developed.
Hence this game, which I call Discover is a version of the same. In fact I like to call it a sequel, as it dismisses some rules where one has to only attack bricks and gain points and instead I have introduced an element of surprise and intuition.
Unlike the one-button control for shooting, here there are two. One for plainly shooting and the other for grabbing. Where grabbing allows you to win exclusive items in the game!
This game has been a golden disc throughout the record player of time. Hence this game is made using the most fundamental concepts of JAVA.
I have been able to achieve fluidity in motion through continuous updating, and refreshing of a 2D whose cells act like pixels of a screen.
The system is smart enough to check correct scores, missile trajectories, placement of items, redemption of items. The system dynamically accommodates end number of users, and can easily produce gaming ranks, deletion of user accounts, edition of users, and for the record generate a printable file for the users.
The system has been made extremely concise, reliable through concepts of inter-dependence where all variables and functions required under certain tasks are kept in a class, which acts as the memory bank of the states, values, and conversions of all variables uses throughout the program            
( Informacion( ) ).
 
 
 
-        Raayaan Sahu
 
 


Methodology

This program contains four classes, namely the Introduction.class, memory hub of the program: Informacion.class, the logic of the game: BrickBreaker.class, ParserAndUserProgress.class also known as the bonding class and finally the brain of the entire program testing.class.
This program is made with fundamental functions which the Java as such has to offer. This program is an animated game, made without any GUI functions but with pure logic and essential maths. 

    The Introduction.class using Unicode characters and a special printing patterns to give the effect of being animated, this delay-print method of animation followed by many stop motion animation studios is achieved by printing single frames ( here characters ) after a short delay in time which gives the following effect.
The class introduces us to Discover: A Brick Breaker Sequel by lafeo_007. It is a necessity since the aesthetics of this game is from the Arcade era which strongly dictates used of pixelated art.
The introduction class also helps the system gather the initial most important information from the user, the name. This allows the system to later check the return of a user or an arrival of a new user altogether. 
The name is saved in a variable statically initialized,

static String name = "JOE HONEY SINGS";

        ParserAndUserProgress picks it up from here. Before the system can progress it needs to make sure the identity of the user. The way the system does that is by maintaining a singular log, “USERS.md”. 
ParserAndUserProgress.resume( ) is initially called to reduce errors which may lead to accumulation of the same named user. Therefore, this method functions under the universal flag boolean variable,

static boolean newUser = true;

This functions only works if the above statement is false, there signifying the presence of an old user. At this instance the file of the old user is retrieved and its contents are extracted. The content are read using BufferedReader and FileReader classes which read the first line allowing the system to split the contents using specifically auto-indented strings  ( shall be discussed ). The data also known as the user-stats are then transferred to the memory bank using public variables, 

static int brickPoint = 0;
brickPoint holds, as suggested, the number of bricks the user has been able to demolish.
static int shots = 0;
Shots holds, as suggested, the total number of shots taken by the user.

Incase the system recognises the entry of a new user, the username is added to the database. 
USERS.md

Using classes such as BufferedWriter, FileWriter and PrintWriter the system writes the new username, on each new line. As to make future searched easier for the system to carry out. 

    The essential information the system requires from the user has been taken. Allowing the system to begin it’s internal processes from initialising the game. 

public static void itemCumBrickGernerator()

itemCumBrickGenerator functions sets the postions of three items or bricks which the user has to collect or demolish respectively,

static char GAMEPLAY[][] = new char [16][32];

This function stores the location of each item or brick in an array called,

static int LOCATOR[][] = new int[3][2];


in a specific sequence. Each row of the array contains the X coordinate and the Y coordinate. The first column or the column having the zeroth index and the second or the column having the first index number hold the mentioned coordinates respectively. 
The function is specifically designed to randomly assign the various bricks and items with the gaming area in the GAMEPLAY array.  As soon as this task is over, the system flags the system by declaring the universal boolean variable, 

static boolean hurdles = false;

This variable by default remains true in order to allow a new game to be started or re-insert the items or bricks however after it’s been done to prevent re-insertion of the items or bricks while a game is being completed. 
    
    Just before the game starts the system incorporates the new changes in the location of the various items using the LOACTOR array and the position of the shooter which will allow the user to understand the distance from his next aim.

The system has everything ready now but it’s still internal. This distance between the internally set array and the array shown to the user is covered by a function again the Informacion class. 

public static void printArray(boolean delay)

This function allows the array to either be printed all at once, or it’s allowed to be printed with a delay of 100 milliseconds. 
Every column printed in the same line, and every row printed on a new line allows the user to actively see the position and graphically understand.

Like any game the system inputs the decisions of users. Using the two of the most logical functions in the program. 
The system first asks the direction the user wants to move in or not move in an at all.
A being for left, D being for right and X being for none.
This is done through,  
    
BrickBreaker.shooterControl(new Scanner(System.in).next().trim().toLowerCase().charAt(0));

    Here, the input is compared to either shift the shooter to the right or the left.
The system uses a formula in order to shift the shooter cell accordingly. The formula is based on a single variable, 


static int ROW_CURRENT_Y;

This variable holds the value of the current column the shooting center of the shooter.
Since the shooter is comprised of three blocks, the side two are dependent of the center block hence the assuming the value of the middle block is n the other two would depend of n when going left like this,

n-1-1  |  n-1  |  n 
 
While going right it’s going to be the exact opposite, 

n  |  n+1  |  n +1 +1

This is done since the array starts from the left, where the index of the various values starts from zero, hence from the center if the shooter needs to go to the left it needs to negate its current position or otherwise add to its current position.

    Now the system is aware of the users decision and needs to analyse the consequence. This consequence is done internally in order to check is any item or brick lies in the current trajectory. The output of this analysis is not revealed until the user decides to acquire the item or demolish the brick.

public static boolean HURDEL()

The trajectory is confirmed by comparing the current value of ROW_CURRENT_Y to the values in the first column or the X coordinates of the various items in the LOCATOR array. 
The hurdle also plays a key role in preventing the overshooting of an item or brick ( this will be covered further in the document ).

The system has now moved the shooter and is awaiting orders to either Shoot S or Grab W

BrickBreaker.lanuchControl(new Scanner(System.in).next().trim().toLowerCase().charAt(0));

launchControl is the single important and most logical function. This function not allows the raw animation of the shot or grab but also checks for item redemption, brick demolishing and removal of demolished or acquired bricks or items. 

    Local variables such as char load = '.' allow the system to animate whether the correct ammo depending on whether the user has chosen shoot or grab which would change the value of the hold to, load = '\u2B1B'; or load = '#'; respectively. 
As soon as an item or brick is encountered the position of the brick or item is changed to the bottom-left corner as to signify the recent user collection by updating the position of that item or brick in the LOCATOR array.
If it’s a brick the universal Informacion.brickPoint; is incremented otherwise the same is done for rewards, Informacion.COMPLETED; is incremented nonetheless. If the user hasn’t shot and pressed X which is for a blank shot the Informacion.shots is incremented. 
The array also resets the current array, updates the array and prints the new array with a delay. If the user has pressed X the delay is declared at 2 milliseconds. However otherwise the delay is kept at 400 milliseconds in order for the user to perceive the animation. This delay is possible due to active change of another local variable named int x;. 
    This function doesn’t automatically check for the presence of an item instead of a brick, it is dependent on another important boolean function rightly named,

public static boolean THINKER();

This functions maintains the value of an item. An item is a rarity is can only acquired seldomly. Hence this function checks for certain variables before allowing the user to gain an item. A universal variable, Informacion.THINKERCOUNTER allows this to take place. Everytime an object is encountered the system calls this function an increments the variable. As and when this variable reaches a point where the it’s remainder is zero when divided by 6. This was done, the player has to continuously play in order to complete 6 successful rounds to attain an item. 
    If the above function does return true the object in the trajectory is declared as an item using the Informacion.newReward; variable, and a function is initiated in order to grant user the required reward,


public static void REWARD()

At this point the brickShot has been incremented as the item is declared after the user has shot the object to decrease the chances of the object being an item. Hence, here the the count of the brickShot is decreased by a 1, as it was an item. However if the user decides to shoot this object the item is demolished the reward is never attained, hence in order to acquire the user has to be able to anticipate and send out a load that of a W - grab. 
The function randomly chooses out of the five options in an array,

final static String[] REWARDS = {"Starbucks Coffee Mug", "Lafeo_007's signature", "Source-code"};

Using a local variable, int DECIDER ;.

After the sequence has been finished the system re-declares newReward as false in order to prevent acquiring of false items.

The system so far has successfully determined the path, demolished or acquired user the brick or the item. The system has various information all scattered, the system is unaware of the changes of the various states in the user progress hence, now it initiates a specialised method in order to do the same. 

public static void currentUserArrayUpdate()

Here the brickPoint, shots, rewardCount are updated and transferred to the,

static String[] currentProgress = new String[4];

This array holds the information from user name to the various other bits of information that play an integral role in remembering user progress and identity.  






Informacion.check();

This function finally ends the sequence for gaming session telling the user that the current level has been completed or it hasn’t been. 
This is also the last function before the game has to be looped back to either the itemCumBrickGenerator is the local variable of function check concludes the completion otherwise reset which resets the array GAMEPLAY in order to incorporate the latest changes, from the placement of the shooter, to the placement of the new items in necessary or removal of the new items from the gaming arena. 

At that instance when the user wants to finish the game, and exit by pressing E the game loop is exited and the third phase of the program starts. 

This third phase is extremely important as this phase is the reason that the game can remember the progress of the user. This phase is entirely internal and uses external file interaction classes previously mentioned such as IO and nio.file.
Here we are going be discussing of what was told on page 3, auto-indenting. As soon as phase 3 starts this, 

public static void currentUser()

function is called. Here the currentProgress array is used to transfer user data from the program to the universally declared external file, 

static String path = (Informacion.name + ".txt");
static final File f = new File(path);

Here a local variable, String buncher = "!*"; is used. The system while transferring specially indents data, by placing special delimiters after every piece of user information. 
User Progress is saved in a certain pattern which is identical to this,




!*name*normal-shots*bricks-shot*rewards

!* will serve  a purpose because * will allow us to directly use the string after splitting from index 1 when used a function called split. 
The String while re-reading when resuming is read from index number 1 and not 0 is to prevent waste processing power in having to remove the '!'.

The SYSTEM also has a channel where a user with the credentials can delete certain users. 

protected static void delUser(String username) throws IOException

This method works in a way like how a system RAM works. For deleting a user, the function reads USERS.md through,

File fCUser = new File(userPath);
BufferedReader brUSERS = new BufferedReader(new FileReader(fCUser));

The sytem while reading the above mentioned file keeps on adding the usernames in,

ArrayList<String> temp = new ArrayList<>();

But as soon as it does come across the user it needs to delete, the system automatically skips the addition of that username.
Now temp contains all the usernames except the one which was to be deleted. Hence technically that uses has been internally deleted however it still exists in USERS.md.
Hence,

pw = new PrintWriter(new BufferedWriter(new FileWriter("USERS.md", false)));

Allows pw to be used to delete all the contents of the file, since this change doesn’t allow pw to append. 
Now the system has removed the all of the contents in the file, hence rewriting the contents which are saved in the temp will allow the final removal of the username to be deleted. 

pw = new PrintWriter(new BufferedWriter(new FileWriter("USERS.md", true)));

This allows us to use pw while appending every username from the array.

The SYSTEM also allows such users to be able to get the RANK of the users, it works in a similar fashion of scanning the USERS.md file which allows the SYSTEM to create a temporary storage of all entries. 
Then comes a specialised array,

    ArrayList <Integer> brickPoints = new ArrayList<Integer>();

The SYSTEM through auto-indetation reads the files of the various uses listed in the above SYSTEM user log, USERS.md. 
Through this method the brickPoints of the listed users is extracted, and stored in the above array. This array is then sorted in descending order. Using Bubble-sort (a simple sorting algorithim) the scores of the users, and the sequence of the usernames corresponding to the the respective users is sorted.

This function also prints the ranks hence can also be used for purposes which don’t require specific credentials such as that needed for delUser function.


________________________________________________________________________

END

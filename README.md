
# minecraft-inversekinematics-tentacle
This is my 3D, Minecraft version of CodingTrain's InverseKinematics coding challange. <br> <br>
https://github.com/CodingTrain/website/tree/main/CodingChallenges/CC_064.3_InverseKinematics_fixed <br>
https://www.youtube.com/watch?v=hbgDqyy8bIw <br> <br>

An example of tentacle that follows player's mouse:
![](https://github.com/EmreNtm/minecraft-inversekinematics-tentacle/blob/main/tentacle-example.gif)

```java
Tentacle tentacle;

// Run this part one time to create the tentacle. 
/* Tentacle is a collection of segments. 
 * player.getEyeLocation(): Starting location of the tentacle.
 * 10: Length of the tentacle.
 * 100: Segment amount of the tentacle. 
 * (We have 100 segments, so the tentacle will have 99 joints.)
 * 1: Particle amount of each segment.
 * Color.RED: Color of each segment particle.
 * 0.35f: Size of the first tentacle particle.
 * 0.35f: Size of the end tentacle particle. */
this.tentacle = new Tentacle(player.getEyeLocation(), 10, 100, 1, Color.RED, 0.35f, 0.35f);
//Disable attachment to the start location so it can move.
this.tentacle.setAttached(false);
```
```java
//Run this part in every tick you want to progress the tentacle.

//Change tentacle's form by telling it where to reach.
this.tentacle.reach(player.getEyeLocation().add(player.getLocation().getDirection().multiply(7)));
//Draw the tentacle to the world.
this.tentacle.display();
```

This is an ability i am currently working on which uses tentacle code to create waterbending arms:
![](https://github.com/EmreNtm/minecraft-inversekinematics-tentacle/blob/main/waterlimbs-example.gif)
![](https://github.com/EmreNtm/minecraft-inversekinematics-tentacle/blob/main/minghua.png)

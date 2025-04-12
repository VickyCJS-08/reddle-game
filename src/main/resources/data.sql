use game;
insert into riddle(answer,level,question) 
values ("egg",1,"What has to be broken before you can use it?"),
       ("candle",1,"I’m tall when I’m young, and I’m short when I’m old. What am I?"),
       ("All of them",1,"What month of the year has 28 days?"),
        ("sponge",1,"What is full of holes but still holds water?"),
        ("Are you asleep yet?",1,"What question can you never answer yes to?"),
        ("future",1,"What is always in front of you but can’t be seen?"),
        ("promise",1,"What can you break, even if you never pick it up or touch it?"),
        ("Your age",1,"What goes up but never comes down?"),
        ("towel",1,"What gets wet while drying?"),
        ("piano",1,"What has many keys but can’t open a single lock?");
        
         insert into medium_riddle (answer,level,question) values
		("He was bald",2,"A man who was outside in the rain without an umbrella didn’t get a single hair on his head wet. Why?"),
        ("bank",2,"I have branches, but no fruit, trunk, or leaves. What am I?"),
        ("echo",2,"What can’t talk but will reply when spoken to?"),
        ("Footstep",2,"The more of me you take, the more you leave behind. What am I?"),
        ("Money",2,"People make me, save me, change me, raise me. What am I?"),
        ("river",2,"What can run but never walks, has a bed but never sleeps, has a mouth but never talks?"),
        ("Light",2,"What can fill a room but takes up no space?"),
        ("mirror",2,"If you drop me, I’m sure to crack, but give me a smile and I’ll always smile back. What am I?"),
        ("needle",2,"What has one eye but can’t see?"),
        ("window",2,"What invention lets you look right through a wall?");
        select * from medium_riddle;
        
         insert into hard_riddle (answer,level,question) values
 ("letter M",3,"What comes once in a minute, twice in a moment, but never in a thousand years?"),
        ("clock",3,"What has hands but can’t clap?"),
        ("table",3,"What has legs but doesn’t walk?"),
        ("artichoke",3,"What has a heart that doesn’t beat?"),
        ("teapot",3,"What begins with T, ends with T, and has T in it?"),
        ("Silence",3,"What is so fragile that saying its name breaks it?"),
        ("ton",3,"Forward I’m heavy, but backward I’m not. What am I?"),
        ("Rain",3,"What comes down but never goes up?"),
        ("There are none",3,"There’s a one-story house in which everything is yellow. What color are the stairs?"),
        ("Incorrectly",3,"What word is spelled incorrectly in every dictionary?");
        select * from hard_riddle;
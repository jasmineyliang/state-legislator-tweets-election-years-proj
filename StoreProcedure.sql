-- GRANT ALL PRIVILEGES ON * . * TO 'cs363'@'localhost';
FLUSH PRIVILEGES;
use group48;

drop Procedure  if exists Q3;
delimiter //
Create Procedure Q3 (IN k INTEGER, IN y INTEGER) 
begin
select count(distinct u.state) as stateNum,GROUP_CONCAT(distinct u.state),h.name 
FROM hastags h, tweets t, users u
where h.tid = t.tid and t.posts_by=u.screenname and year_posts = y and u.state <> "na"
group by h.name
ORDER BY stateNum DESC LIMIT k
;
end; //
delimiter ;


drop Procedure if exists Q7;
delimiter //
Create Procedure Q7 (IN hashtag varchar(766), IN state varchar(766), IN k INTEGER, IN m INTEGER,IN y INTEGER)
begin
select count(t.tid) as tweet_count, u.screenname,u.category
from hastags h,tweets t, users u
where h.tid = t.tid and t.posts_by=u.screenname and u.state = state and h.name = hashtag and month_posts = m and year_posts = y
group by u.screenname
ORDER BY tweet_count DESC LIMIT k
;
end; //
delimiter ;


drop Procedure if exists Q9;
delimiter //
Create Procedure Q9 (IN k INTEGER, IN subcategory varchar(766))
begin
select u.screenname, u.subcategory, u.numFollowers
from users u
where u.subcategory = subcategory
 ORDER BY u.numFollowers DESC LIMIT k
;
end; //
delimiter ;


drop Procedure if exists Q16;
delimiter //
Create Procedure Q16 (IN k INTEGER, IN m INTEGER, IN y INTEGER)
begin
select u.screenname, u.category, t.text, t.retweet_count, h.address
from users u, tweets t, hasurls h
where t.posts_by=u.screenname and h.tid = t.tid and month_posts = m and year_posts = y
ORDER BY t.retweet_count DESC LIMIT k
;
end; //
delimiter ;

drop Procedure if exists Q18;
delimiter //
Create Procedure Q18 (IN k INTEGER, IN subcategory varchar(766),IN m INTEGER, IN y INTEGER)
begin

select m.screenname as mentionedUser, u1.state, GROUP_CONCAT(distinct u.screenname)
FROM mentions m
inner join users u1 on m.screenname = u1.screenname
inner join tweets t on m.tid = t.tid 
inner join users u on t.posts_by = u.screenname
where u.subcategory = "GOP" and month_posts = m and year_posts = y 
group by m.screenname
ORDER BY count(m.tid) DESC LIMIT k
;
end; //
delimiter ;


drop Procedure if exists Q23;
delimiter //
Create Procedure Q23 (IN k INTEGER, in subcategory varchar(766), IN m varchar(766), IN y INTEGER )
begin
select h.name,count(h.tid) as num_uses
from users u, tweets t, hastags h
where h.tid = t.tid and t.posts_by=u.screenname and u.subcategory = subcategory and year_posts = y and find_in_set(month_posts, m)
group by h.name
ORDER BY num_uses DESC LIMIT k
;
end; //
delimiter ;




drop Procedure if exists deleteUsers;
delimiter //
Create Procedure deleteUsers (In username varchar(766))
begin
DELETE 
FROM mentions 
WHERE screenname = username;

delete hastags
from hastags
inner join tweets on hastags.tid = tweets.tid
inner join users on users.screenname = tweets.posts_by
where users.screenname = username ;

delete hasurls
from hasurls
inner join tweets on hasurls.tid = tweets.tid
inner join users on users.screenname = tweets.posts_by
where users.screenname = username ;


SET FOREIGN_KEY_CHECKS=0;
delete tweets
from tweets
inner join users on users.screenname = tweets.posts_by
where users.screenname = username; 
SET FOREIGN_KEY_CHECKS=1;

delete 
from users
where users.screenname = username; 

end;//
delimiter ;


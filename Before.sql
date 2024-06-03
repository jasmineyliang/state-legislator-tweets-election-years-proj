-- Q3 done
select count(distinct u.state) as stateNum, GROUP_CONCAT(distinct u.state),h.name 
FROM hastags h, tweets t, users u
where h.tid = t.tid and t.posts_by=u.screenname and year(createdTime) = 2016 and u.state <> "na"
group by h.name
ORDER BY stateNum DESC LIMIT 5
;




-- Q7 done 
select count(t.tid) as tweet_count, u.screenname,u.category
from hastags h,tweets t, users u
where h.tid = t.tid and t.posts_by=u.screenname and u.state = "North Carolina" and h.name = "GOPDebate" and month(createdTime) = 2 and year(createdTime) = 2016
group by u.screenname
ORDER BY tweet_count DESC LIMIT 5
;



-- Q9 done 
select u.screenname, u.subcategory, u.numFollowers
from users u
where u.subcategory = "GOP"
ORDER BY u.numFollowers DESC LIMIT 5
;



-- Q16 done 

select u.screenname, u.category, t.text, t.retweet_count, h.address
from users u, tweets t, hasurls h
where t.posts_by=u.screenname and h.tid = t.tid and month(createdTime)=2 and year(createdTime) = 2016
ORDER BY t.retweet_count DESC LIMIT 5
;


select m.screenname as mentionedUser, u1.state, GROUP_CONCAT(distinct u.screenname)
FROM mentions m
inner join users u1 on m.screenname = u1.screenname
inner join tweets t on m.tid = t.tid 
inner join users u on t.posts_by = u.screenname
where u.subcategory = "GOP" and month(createdTime) = 1 and year(createdTime) = 2016 
group by m.screenname
ORDER BY count(m.tid) DESC LIMIT 5
;



-- Q23 DONE!!
select h.name,count(h.tid) as num_uses
from users u, tweets t, hastags h
where h.tid = t.tid and t.posts_by=u.screenname and u.subcategory =  "GOP" and year(createdTime) = 2016 and find_in_set(month(createdTime), "1,2,3")
group by h.name
ORDER BY num_uses DESC LIMIT 5
;
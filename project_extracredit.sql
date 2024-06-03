-- INSERT into test.newtweet
-- SELECT tid, textbody, retweet_count, retweeted, day(posted), month(posted), year(posted) FROM test.tweet;

-- select *
-- from tweet
-- where month(posted)=5;

-- select *
-- from newtweet
-- where month_posted=5;

-- create index postedIdx on tweet (posted);
-- create index monthIdx on newtweet (month_posted);








-- project extra credit 2

-- SELECT count(distinct screenname)
-- FROM TWEET.users;

-- SELECT count(distinct tid)
-- FROM TWEET.tweets;

-- SELECT count(distinct name)
-- FROM TWEET.hashtags;

-- SELECT count(distinct address)
-- FROM TWEET.urls;

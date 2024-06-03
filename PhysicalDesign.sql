-- Increase buffer pool size for Q3,Q7 optimization
-- SET GLOBAL innodb_buffer_pool_size=402653184;



-- Insert index for users attribution for Q9,Q16 optimization
-- create index postedIdx on users (screenname);


-- seperate month and year from the date for Q18 Q23, optimization
-- drop index postedIdx on users (screenname);

-- DOTMOVE!!!!
-- ALTER TABLE tweets
-- ADD COLUMN month_posts int AFTER posts_by;

-- ALTER TABLE tweets
-- ADD COLUMN year_posts int AFTER month_posts;

-- SET SQL_SAFE_UPDATES = 0;
-- update tweets set month_posts  =  month(createdTime) ;
-- update tweets set year_posts  =  year(createdTime) ;

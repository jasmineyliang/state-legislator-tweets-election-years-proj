use group48;
SET SQL_SAFE_UPDATES = 0;
FLUSH PRIVILEGES;
use group48;

drop PROCEDURE if exists UpdateState;
delimiter //
CREATE PROCEDURE UpdateState()
begin
UPDATE users
set state = "Alabama"
where state = "AL";

UPDATE users
set state = "Alaska"
where state = "AK";

UPDATE users
set state = "Arizona"
where state = "AZ";

UPDATE users
set state = "Arkansas"
where state = "AR";

UPDATE users
set state = "California"
where state = "CA";

UPDATE users
set state = "Colorado"
where state = "CO";

UPDATE users
set state = "Connecticut"
where state = "CT";

UPDATE users
set state = "Delaware"
where state = "DE";

UPDATE users
set state = "District of Columbia"
where state = "DC";


UPDATE users
set state = "Florida"
where state = "FL";

UPDATE users
set state = "Georgia"
where state = "GA";


UPDATE users
set state = "Hawaii"
where state = "HI";

UPDATE users
set state = "Idaho"
where state = "ID";

UPDATE users
set state = "Illinois"
where state = "IL";

UPDATE users
set state = "Indiana"
where state = "IN";

UPDATE users
set state = "Iowa"
where state = "IA";

UPDATE users
set state = "Kansas"
where state = "KS";

UPDATE users
set state = "Kentucky"
where state = "KY";

UPDATE users
set state = "Louisiana"
where state = "LA";

UPDATE users
set state = "Maine"
where state = "ME";

UPDATE users
set state = "Maryland"
where state = "MD";

UPDATE users
set state = "Massachusetts"
where state = "MA";

UPDATE users
set state = "Michigan"
where state = "MI";

UPDATE users
set state = "Minnesota"
where state = "MN";

UPDATE users
set state = "Mississippi"
where state = "MS";

UPDATE users
set state = "Missouri"
where state = "MO";

UPDATE users
set state = "Montana"
where state = "MT";

UPDATE users
set state = "Nebraska"
where state = "NE";

UPDATE users
set state = "Nevada"
where state = "NV";

UPDATE users
set state = "New Hampshire"
where state = "NH";

UPDATE users
set state = "New Jersey"
where state = "NJ";

UPDATE users
set state = "New Mexico"
where state = "NM";

UPDATE users
set state = "New York"
where state = "NY";

UPDATE users
set state = "North Carolina"
where state = "NC";

UPDATE users
set state = "North Dakota"
where state = "ND";

UPDATE users
set state = "Ohio"
where state = "OH";

UPDATE users
set state = "Oklahoma"
where state = "OK";

UPDATE users
set state = "Oregon"
where state = "OR";

UPDATE users
set state = "Pennsylvania"
where state = "PA";

UPDATE users
set state = "Rhode Island"
where state = "RI";

UPDATE users
set state = "South Carolina"
where state = "SC";

UPDATE users
set state = "South Dakota"
where state = "SD";

UPDATE users
set state = "Tennessee"
where state = "TN";

UPDATE users
set state = "Texas"
where state = "TX";

UPDATE users
set state = "Utah"
where state = "UT";

UPDATE users
set state = "Vermont"
where state = "VT";

UPDATE users
set state = "Virginia"
where state = "VA";

UPDATE users
set state = "Washington"
where state = "WA";

UPDATE users
set state = "West Virginia"
where state = "WV";

UPDATE users
set state = "Wisconsin"
where state = "WI";

UPDATE users
set state = "Wyoming"
where state = "WY";

UPDATE users
set state = "na"
where state = "";
end; //
delimiter ;


call UpdateState(); 










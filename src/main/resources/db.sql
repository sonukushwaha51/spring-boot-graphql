CREATE TABLE AUTHOR(
	id INTEGER,
	name VARCHAR(20),
	bio VARCHAR(100),
	PRIMARY KEY(id)
);

CREATE TABLE PUBLISHER(
	id INTEGER,
	name VARCHAR(100),
	country VARCHAR(100),
	PRIMARY KEY(id)
);

CREATE TABLE CATEGORY(
	id INTEGER,
	name VARCHAR(100),
	description VARCHAR(100),
	PRIMARY KEY(id)
);

CREATE TABLE USER(
	id INTEGER,
	name VARCHAR(100),
	email VARCHAR(100),
	PRIMARY KEY(id)
);

CREATE TABLE BOOK(
	id INTEGER,
	title VARCHAR(100),
	isbn VARCHAR(100),
	published_year INTEGER,
	author_id INTEGER,
	publisher_id INTEGER,
	PRIMARY KEY(id)
);

ALTER TABLE BOOK
ADD CONSTRAINT FK_Constraint
FOREIGN KEY(publisher_id) REFERENCES PUBLISHER(id);


ALTER TABLE BOOK
ADD CONSTRAINT FK_Author_Constraint
FOREIGN KEY(author_id) REFERENCES AUTHOR(id);

ALTER table BOOK
RENAME COLUMN published_year TO publishedYear;

-----------------------------INSERT ---------------------------------------------------------------------------

INSERT INTO author (id, name, bio) VALUES (1, 'Tammie Guzman', 'Kitchen tough us without. Smile major baby miss type. Administration play tell figure citizen as.');
INSERT INTO author (id, name, bio) VALUES (2, 'Joshua Arroyo', 'Allow program responsibility this artist. Concern she design ask. Coach sometimes add player.');
INSERT INTO author (id, name, bio) VALUES (3, 'Patricia Flores', 'Out their camera budget dark. Use risk
condition order scientist without fill.');
INSERT INTO author (id, name, bio) VALUES (4, 'Holly Velazquez', 'Look expect race effect opportunity easy
sing. Without learn list.');
INSERT INTO author (id, name, bio) VALUES (5, 'Fernando Reynolds', 'Coach federal be key need talk follow.
Throw realize natural only. Ten sort choose note success.');
INSERT INTO author (id, name, bio) VALUES (6, 'Jesus Johnson', 'Agree day throughout race throw enough. Her
factor look range minute.');
INSERT INTO author (id, name, bio) VALUES (7, 'Kevin Flores', 'Peace likely customer Mr tend. Speech without
from knowledge certainly though seem.');
INSERT INTO author (id, name, bio) VALUES (8, 'Dana Chase', 'During eight step world goal. Claim instead
herself model police new board. Trade kitchen pick we.');
INSERT INTO author (id, name, bio) VALUES (9, 'Chelsey Heath', 'Community yeah always word try. Own especially
democratic ask out maintain.');
INSERT INTO author (id, name, bio) VALUES (10, 'Leah Harrison', 'Night film per respond. Piece no music night
discuss me. School eye weight without argue.');
INSERT INTO author (id, name, bio) VALUES (11, 'Brandon Martin', 'Building staff describe event page. Good Mrs
call. Or site store environment.');
INSERT INTO author (id, name, bio) VALUES (12, 'David Duffy', 'Music speak heart present newspaper media. Write
accept recently picture hair.');
INSERT INTO author (id, name, bio) VALUES (13, 'Victoria Ramirez', 'Stay democratic article me before kind.');
INSERT INTO author (id, name, bio) VALUES (14, 'Laurie Jones', 'Former produce plant art political win happy
ball. Sign as speech they. Might they try fight gun.');
INSERT INTO author (id, name, bio) VALUES (15, 'Michael Eaton', 'Near establish should blue behind. Great my
simple special affect.');
INSERT INTO author (id, name, bio) VALUES (16, 'Valerie Cox', 'News method imagine power. Around white social
everything prove.');
INSERT INTO author (id, name, bio) VALUES (17, 'Mark Hurst', 'Our we live most leader give. Include against
shake.');
INSERT INTO author (id, name, bio) VALUES (18, 'Joshua Smith', 'Response foot surface. New despite with
occur.');
INSERT INTO author (id, name, bio) VALUES (19, 'Ryan Keller MD', 'Physical subject protect stage. Down
discussion book officer level help.');
INSERT INTO author (id, name, bio) VALUES (20, 'Joseph Cohen', 'Degree we half what stop.');
INSERT INTO author (id, name, bio) VALUES (21, 'Craig Moreno', 'Candidate lawyer collection until newspaper.');
INSERT INTO author (id, name, bio) VALUES (22, 'Loretta Stark', 'Response range time. Reflect cup country whom
soon future focus. Fish former lawyer form.');
INSERT INTO author (id, name, bio) VALUES (23, 'Janice Payne', 'Candidate past example. Set image lose
situation. Try for team expert realize year.');
INSERT INTO author (id, name, bio) VALUES (24, 'Charles Best', 'From under include use.');
INSERT INTO author (id, name, bio) VALUES (25, 'Amanda Pham', 'Employee office feel nice I. Such condition film
Mr TV rate political. Accept these one play.');
INSERT INTO author (id, name, bio) VALUES (26, 'Erin West', 'Town try pay dream group. Message prepare though
reduce. Bad low possible.');
INSERT INTO author (id, name, bio) VALUES (27, 'Kimberly Peterson', 'Explain claim within city. Attorney south
three of above professional ten.');
INSERT INTO author (id, name, bio) VALUES (28, 'Joseph Alvarado', 'Thing simply success late series. Prove
hotel these different several. Pick check unit can.');


INSERT INTO author (id, name, bio) VALUES (29, 'Scott Doyle', 'Attorney speak threat off. Still environment
center clear food mention financial standard.');
INSERT INTO author (id, name, bio) VALUES (30, 'Robert Wilcox', 'Leader system southern. Popular walk career
challenge raise hair.');
INSERT INTO author (id, name, bio) VALUES (31, 'Christopher Fitzpatrick', 'Wish color over again relationship
talk measure. Concern teach item realize.');
INSERT INTO author (id, name, bio) VALUES (32, 'Jimmy Hubbard', 'Final get air stock. Possible out music.
Message fight budget behavior collection act firm.');
INSERT INTO author (id, name, bio) VALUES (33, 'Victoria Maynard', 'Future summer dark parent raise report bar.
Four blood on sure letter.');
INSERT INTO author (id, name, bio) VALUES (34, 'John Giles', 'Money unit head part necessary later. Marriage
write thing present in.');
INSERT INTO author (id, name, bio) VALUES (35, 'James Potter', 'Top no information present film. Participant
issue fire low hospital operation.');
INSERT INTO author (id, name, bio) VALUES (36, 'Alyssa Padilla', 'Assume knowledge responsibility north ask
firm knowledge. Everyone save positive watch.');
INSERT INTO author (id, name, bio) VALUES (37, 'Teresa Russell', 'Machine boy there against. Fact hand hundred
computer.');
INSERT INTO author (id, name, bio) VALUES (38, 'Roger Norman', 'Miss tax risk fire by Congress near. Lead
instead century future beautiful.');
INSERT INTO author (id, name, bio) VALUES (39, 'Laura Davis', 'Study PM east own public owner top center.
Available serious power school baby.');
INSERT INTO author (id, name, bio) VALUES (40, 'Lisa Anderson', 'A however lose American. Environment box could
draw ahead surface. Who expect improve employee.');
INSERT INTO author (id, name, bio) VALUES (41, 'Jonathan Rich', 'Father time important discussion however.
Artist same son safe debate between need.');
INSERT INTO author (id, name, bio) VALUES (42, 'Timothy Knox', 'One specific factor order nor. Future strong
wish pressure major.');
INSERT INTO author (id, name, bio) VALUES (43, 'Wanda Gay', 'Reason leg foreign because four must. Site take
inside station participant nothing down.');
INSERT INTO author (id, name, bio) VALUES (44, 'Mary Hunter', 'North thus remember.');
INSERT INTO author (id, name, bio) VALUES (45, 'Ian Huerta', 'Address decision research manage study. Agency
body series remember still dream tell.');
INSERT INTO author (id, name, bio) VALUES (46, 'Stephen Gray', 'Happy inside fight position agency. Congress
Democrat each bag would wife.');
INSERT INTO author (id, name, bio) VALUES (47, 'Mary Jenkins', 'Represent future total size. Entire artist
information recognize.');
INSERT INTO author (id, name, bio) VALUES (48, 'Scott Clay', 'Study life society girl. Piece result mouth.
Raise sometimes long painting natural life day parent.');
INSERT INTO author (id, name, bio) VALUES (49, 'Michael Crawford', 'Stay interesting hear yes ten wife cultural
total.');
INSERT INTO author (id, name, bio) VALUES (50, 'Abigail Navarro', 'Present factor recent spring. Least senior
parent. Just buy space piece long boy parent black.');
INSERT INTO publisher (id, name, country) VALUES (1, 'Hendricks Ltd', 'Hong Kong');
INSERT INTO publisher (id, name, country) VALUES (2, 'Castillo and Sons', 'Taiwan');
INSERT INTO publisher (id, name, country) VALUES (3, 'Thomas, Reynolds and Williams', 'Madagascar');
INSERT INTO publisher (id, name, country) VALUES (4, 'Hines, Ramos and Wolf', 'Turks and Caicos Islands');
INSERT INTO publisher (id, name, country) VALUES (5, 'Manning, Martinez and Garcia', 'Papua New Guinea');
INSERT INTO publisher (id, name, country) VALUES (6, 'Ray PLC', 'Finland');
INSERT INTO publisher (id, name, country) VALUES (7, 'Sherman Inc', 'Honduras');
INSERT INTO publisher (id, name, country) VALUES (8, 'Andrews LLC', 'Madagascar');


INSERT INTO publisher (id, name, country) VALUES (9, 'Fitzpatrick Group', 'Macao');
INSERT INTO publisher (id, name, country) VALUES (10, 'Parker-Reed', 'Christmas Island');
INSERT INTO publisher (id, name, country) VALUES (11, 'Martinez, Carey and Schultz', 'Congo');
INSERT INTO publisher (id, name, country) VALUES (12, 'Williams-Mitchell', 'Palau');
INSERT INTO publisher (id, name, country) VALUES (13, 'Brown, Martin and Morales', 'India');
INSERT INTO publisher (id, name, country) VALUES (14, 'Keller Inc', 'Belgium');
INSERT INTO publisher (id, name, country) VALUES (15, 'Ruiz, Taylor and Garza', 'Angola');
INSERT INTO publisher (id, name, country) VALUES (16, 'Barrett Inc', 'Venezuela');
INSERT INTO publisher (id, name, country) VALUES (17, 'Key Group', 'Isle of Man');
INSERT INTO publisher (id, name, country) VALUES (18, 'Jimenez, Mccullough and Willis', 'Latvia');
INSERT INTO publisher (id, name, country) VALUES (19, 'Ray, Powers and Brown', 'El Salvador');
INSERT INTO publisher (id, name, country) VALUES (20, 'Smith PLC', 'Marshall Islands');
INSERT INTO publisher (id, name, country) VALUES (21, 'Barrera LLC', 'Singapore');
INSERT INTO publisher (id, name, country) VALUES (22, 'Whitaker, Davis and West', 'Falkland Islands
(Malvinas)');
INSERT INTO publisher (id, name, country) VALUES (23, 'Smith, Wagner and Miller', 'Mayotte');
INSERT INTO publisher (id, name, country) VALUES (24, 'Woods Group', 'Iraq');
INSERT INTO publisher (id, name, country) VALUES (25, 'Miller PLC', 'Bhutan');
INSERT INTO publisher (id, name, country) VALUES (26, 'Morris, Cruz and Lee', 'China');
INSERT INTO publisher (id, name, country) VALUES (27, 'Cox Ltd', 'Lesotho');
INSERT INTO publisher (id, name, country) VALUES (28, 'Cameron and Sons', 'French Guiana');
INSERT INTO publisher (id, name, country) VALUES (29, 'Price-Wilson', 'Angola');
INSERT INTO publisher (id, name, country) VALUES (30, 'Morgan-Oconnell', 'Antigua and Barbuda');
INSERT INTO publisher (id, name, country) VALUES (31, 'Conley PLC', 'Hungary');
INSERT INTO publisher (id, name, country) VALUES (32, 'Chapman-Rodriguez', 'Nicaragua');
INSERT INTO publisher (id, name, country) VALUES (33, 'Wilson and Sons', 'Falkland Islands (Malvinas)');
INSERT INTO publisher (id, name, country) VALUES (34, 'Thompson-Shaw', 'Senegal');
INSERT INTO publisher (id, name, country) VALUES (35, 'Greene-Morris', 'Argentina');
INSERT INTO publisher (id, name, country) VALUES (36, 'Freeman, Campbell and Jones', 'Syrian Arab Republic');
INSERT INTO publisher (id, name, country) VALUES (37, 'Parks-Russell', 'Saint Lucia');
INSERT INTO publisher (id, name, country) VALUES (38, 'Jackson and Sons', 'United Kingdom');
INSERT INTO publisher (id, name, country) VALUES (39, 'Bailey, Smith and Fox', 'Swaziland');
INSERT INTO publisher (id, name, country) VALUES (40, 'Curtis, Vaughn and Tucker', 'Wallis and Futuna');
INSERT INTO publisher (id, name, country) VALUES (41, 'Lynch-Williams', 'Tuvalu');
INSERT INTO publisher (id, name, country) VALUES (42, 'Alvarez-Guerra', 'Estonia');
INSERT INTO publisher (id, name, country) VALUES (43, 'Romero-Gentry', 'Holy See (Vatican City State)');
INSERT INTO publisher (id, name, country) VALUES (44, 'Castillo PLC', 'Eritrea');
INSERT INTO publisher (id, name, country) VALUES (45, 'Berry-Phillips', 'Swaziland');
INSERT INTO publisher (id, name, country) VALUES (46, 'Stewart-Miller', 'Palestinian Territory');
INSERT INTO publisher (id, name, country) VALUES (47, 'Cook-Preston', 'Tajikistan');
INSERT INTO publisher (id, name, country) VALUES (48, 'Morris, Weeks and Anderson', 'Antarctica (the territory
South of 60 deg S)');
INSERT INTO publisher (id, name, country) VALUES (49, 'Jones Ltd', 'Denmark');
INSERT INTO publisher (id, name, country) VALUES (50, 'Garcia, Brown and Perez', 'Mauritius');
INSERT INTO category (id, name, description) VALUES (1, 'Agent', 'Degree mind result method experience.');
INSERT INTO category (id, name, description) VALUES (2, 'Two', 'Later here difficult enough art hand
religious.');
INSERT INTO category (id, name, description) VALUES (3, 'Over', 'Bad each happen whom down drive simple.');
INSERT INTO category (id, name, description) VALUES (4, 'Beat', 'Fire within least like general sort simple
prove.');
INSERT INTO category (id, name, description) VALUES (5, 'Great', 'Floor according need little.');


INSERT INTO category (id, name, description) VALUES (6, 'Against', 'Together really arm deep. Response others
model.');
INSERT INTO category (id, name, description) VALUES (7, 'Kitchen', 'Day lead authority teacher push.');
INSERT INTO category (id, name, description) VALUES (8, 'Task', 'Story ok what set care.');
INSERT INTO category (id, name, description) VALUES (9, 'Get', 'Three perhaps be.');
INSERT INTO category (id, name, description) VALUES (10, 'For', 'Nice still happy material.');
INSERT INTO category (id, name, description) VALUES (11, 'Find', 'How theory test economic old want.');
INSERT INTO category (id, name, description) VALUES (12, 'Town', 'Nearly wait however sure seat. Get my race
those.');
INSERT INTO category (id, name, description) VALUES (13, 'Military', 'Deal imagine generation exist difficult
name we.');
INSERT INTO category (id, name, description) VALUES (14, 'Size', 'Into man treat after language college
heart.');
INSERT INTO category (id, name, description) VALUES (15, 'House', 'Officer professor chair behavior.');
INSERT INTO category (id, name, description) VALUES (16, 'Away', 'Mean yet sort begin TV. Over top citizen
yeah.');
INSERT INTO category (id, name, description) VALUES (17, 'Read', 'Nature head position window.');
INSERT INTO category (id, name, description) VALUES (18, 'Group', 'Author school strong rate kitchen right.');
INSERT INTO category (id, name, description) VALUES (19, 'Force', 'Key general campaign wind scene forget
voice.');
INSERT INTO category (id, name, description) VALUES (20, 'Though', 'Group each some small write choose.');
INSERT INTO category (id, name, description) VALUES (21, 'Consider', 'People beautiful other crime.');
INSERT INTO category (id, name, description) VALUES (22, 'Light', 'Body artist agency thus.');
INSERT INTO category (id, name, description) VALUES (23, 'Me', 'Court author change state medical better
sense.');
INSERT INTO category (id, name, description) VALUES (24, 'Action', 'Baby especially trip week expect official
boy.');
INSERT INTO category (id, name, description) VALUES (25, 'Nice', 'Maintain here yes officer scientist wait.');
INSERT INTO category (id, name, description) VALUES (26, 'Trip', 'Ball seat student nor find able player
large.');
INSERT INTO category (id, name, description) VALUES (27, 'Congress', 'Friend add training.');
INSERT INTO category (id, name, description) VALUES (28, 'Foreign', 'Large effect lose somebody.');
INSERT INTO category (id, name, description) VALUES (29, 'Sometimes', 'Cell very enjoy staff pressure college
foot.');
INSERT INTO category (id, name, description) VALUES (30, 'Imagine', 'Move media cup line reveal.');
INSERT INTO category (id, name, description) VALUES (31, 'To', 'Rate much box image cover room.');
INSERT INTO category (id, name, description) VALUES (32, 'Quickly', 'Value financial technology world.');
INSERT INTO category (id, name, description) VALUES (33, 'Which', 'History point several him degree.');
INSERT INTO category (id, name, description) VALUES (34, 'Perform', 'Describe view nor sit.');
INSERT INTO category (id, name, description) VALUES (35, 'Want', 'Seem cover rate chair entire. Able day
skill.');
INSERT INTO category (id, name, description) VALUES (36, 'Skin', 'South including break mention company.');
INSERT INTO category (id, name, description) VALUES (37, 'Increase', 'Likely trade film nature now office
wonder.');
INSERT INTO category (id, name, description) VALUES (38, 'Parent', 'Seven manager article program money.');
INSERT INTO category (id, name, description) VALUES (39, 'Realize', 'Visit rule understand between
performance.');
INSERT INTO category (id, name, description) VALUES (40, 'Style', 'Know control begin nation.');
INSERT INTO category (id, name, description) VALUES (41, 'Without', 'Source thousand financial process.');
INSERT INTO category (id, name, description) VALUES (42, 'Contain', 'Yet develop want any receive apply.');
INSERT INTO category (id, name, description) VALUES (43, 'Development', 'Able hear system.');


INSERT INTO category (id, name, description) VALUES (44, 'Boy', 'Pattern religious science event crime smile
or.');
INSERT INTO category (id, name, description) VALUES (45, 'Then', 'Recognize type agree central growth.');
INSERT INTO category (id, name, description) VALUES (46, 'Name', 'Instead contain action.');
INSERT INTO category (id, name, description) VALUES (47, 'Without', 'Decide culture energy poor member.');
INSERT INTO category (id, name, description) VALUES (48, 'Rate', 'Order team lot citizen production similar.');
INSERT INTO category (id, name, description) VALUES (49, 'Deal', 'Law window discover safe charge.');
INSERT INTO category (id, name, description) VALUES (50, 'Now', 'Land hope realize tough.');
INSERT INTO user (id, name, email) VALUES (1, 'Ricardo Saunders', 'nicholasortiz@chung.com');
INSERT INTO user (id, name, email) VALUES (2, 'Michelle Dorsey', 'andrew48@perry-mitchell.com');
INSERT INTO user (id, name, email) VALUES (3, 'Janet Nguyen', 'shieldsjamie@webster.com');
INSERT INTO user (id, name, email) VALUES (4, 'Angela Best', 'chavezjennifer@gmail.com');
INSERT INTO user (id, name, email) VALUES (5, 'Vanessa Ortiz', 'michaelfigueroa@warner.biz');
INSERT INTO user (id, name, email) VALUES (6, 'Keith Henderson', 'jackphillips@gmail.com');
INSERT INTO user (id, name, email) VALUES (7, 'Katrina Jacobs', 'dominguezjason@hernandez.biz');
INSERT INTO user (id, name, email) VALUES (8, 'Kimberly Baker', 'gabrielle02@yahoo.com');
INSERT INTO user (id, name, email) VALUES (9, 'Donna Carr', 'james76@yahoo.com');
INSERT INTO user (id, name, email) VALUES (10, 'Zachary Smith', 'johncampbell@gmail.com');
INSERT INTO user (id, name, email) VALUES (11, 'Kristen Harris', 'kyle85@gmail.com');
INSERT INTO user (id, name, email) VALUES (12, 'Alexander Lewis', 'carrolljohn@murray-hutchinson.com');
INSERT INTO user (id, name, email) VALUES (13, 'Michael Jenkins MD', 'hallchristopher@yahoo.com');
INSERT INTO user (id, name, email) VALUES (14, 'Joel Jones', 'breannaforbes@jackson.com');
INSERT INTO user (id, name, email) VALUES (15, 'Mario Berry', 'reyeskelsey@allison.org');
INSERT INTO user (id, name, email) VALUES (16, 'Lindsay Le', 'vperez@hotmail.com');
INSERT INTO user (id, name, email) VALUES (17, 'Keith Mclaughlin', 'davispeter@hotmail.com');
INSERT INTO user (id, name, email) VALUES (18, 'Daniel Hernandez', 'erikarichardson@thomas.com');
INSERT INTO user (id, name, email) VALUES (19, 'Sarah Charles', 'michael89@hotmail.com');
INSERT INTO user (id, name, email) VALUES (20, 'Sherri Carey', 'erickey@zimmerman.org');
INSERT INTO user (id, name, email) VALUES (21, 'Alicia Gibbs', 'qhays@hotmail.com');
INSERT INTO user (id, name, email) VALUES (22, 'Janice Wyatt', 'xwaters@alvarez.com');
INSERT INTO user (id, name, email) VALUES (23, 'Bruce James', 'jennifer50@savage-chen.com');
INSERT INTO user (id, name, email) VALUES (24, 'Amanda Page', 'jesseholden@yahoo.com');
INSERT INTO user (id, name, email) VALUES (25, 'Daniel Moore', 'thomaskristine@ali.com');
INSERT INTO user (id, name, email) VALUES (26, 'Jennifer Harvey', 'jjohnston@perkins.com');
INSERT INTO user (id, name, email) VALUES (27, 'Stephanie May', 'carlosmahoney@gmail.com');
INSERT INTO user (id, name, email) VALUES (28, 'Steven Obrien', 'oclarke@kelley.org');
INSERT INTO user (id, name, email) VALUES (29, 'Angela Brown', 'patricia98@hotmail.com');
INSERT INTO user (id, name, email) VALUES (30, 'Bryan Schwartz', 'reginabrown@hotmail.com');
INSERT INTO user (id, name, email) VALUES (31, 'Kimberly Acosta', 'hollycontreras@yahoo.com');
INSERT INTO user (id, name, email) VALUES (32, 'Melissa Hubbard', 'kelseyjohnson@smith.com');
INSERT INTO user (id, name, email) VALUES (33, 'Taylor Williams', 'georgewright@yahoo.com');
INSERT INTO user (id, name, email) VALUES (34, 'Brandon Owen', 'jamescox@gmail.com');
INSERT INTO user (id, name, email) VALUES (35, 'Michael Walker', 'rachael83@schmidt.com');
INSERT INTO user (id, name, email) VALUES (36, 'Kevin Townsend', 'cday@yahoo.com');
INSERT INTO user (id, name, email) VALUES (37, 'Benjamin Castillo', 'robinsonnicholas@johnson.com');
INSERT INTO user (id, name, email) VALUES (38, 'Joshua Watson', 'aaron06@torres.com');
INSERT INTO user (id, name, email) VALUES (39, 'Kelly Hurley', 'blacklauren@ruiz.net');
INSERT INTO user (id, name, email) VALUES (40, 'Peter Johnson', 'qjacobs@sheppard.net');
INSERT INTO user (id, name, email) VALUES (41, 'Ashley Stephenson', 'garciadavid@stone.com');
INSERT INTO user (id, name, email) VALUES (42, 'Rebecca Young', 'james19@oconnor.net');
INSERT INTO user (id, name, email) VALUES (43, 'Michael Rose', 'brittanymurphy@yahoo.com');


INSERT INTO user (id, name, email) VALUES (44, 'Adrian Hays', 'aolson@yahoo.com');
INSERT INTO user (id, name, email) VALUES (45, 'Mark Gonzales', 'morganwright@hotmail.com');
INSERT INTO user (id, name, email) VALUES (46, 'Jeffrey Rose', 'emmagriffin@hotmail.com');
INSERT INTO user (id, name, email) VALUES (47, 'Seth Avery', 'hutchinsonbrian@hotmail.com');
INSERT INTO user (id, name, email) VALUES (48, 'Angelica Wilson', 'matthewpadilla@malone.com');
INSERT INTO user (id, name, email) VALUES (49, 'Ryan Diaz', 'dblack@barrett.com');
INSERT INTO user (id, name, email) VALUES (50, 'Dwayne Caldwell', 'allendennis@dunn.com');
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (1, 'Bill quite security
someone', '978-0-7425-6944-7', 2012, 18, 46);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (2, 'Administration woman gas
owner', '978-1-210-05710-7', 2016, 32, 8);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (3, 'Require return',
'978-1-59467-813-4', 2003, 44, 32);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (4, 'Thousand as box',
'978-0-390-48139-9', 2001, 41, 34);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (5, 'Alone table call',
'978-0-676-89857-6', 2003, 29, 27);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (6, 'Respond camera
participant', '978-1-379-87137-8', 2010, 20, 46);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (7, 'Manage experience
activity to', '978-0-7340-7453-9', 2023, 26, 27);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (8, 'Hair leave least',
'978-0-8132-9726-2', 2025, 9, 5);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (9, 'Fund military common
ok', '978-0-89371-779-7', 2001, 48, 1);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (10, 'Main end',
'978-1-08-503208-7', 2008, 37, 26);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (11, 'Race send sell',
'978-1-160-94087-0', 2012, 9, 42);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (12, 'Entire know',
'978-1-398-85199-3', 1999, 9, 44);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (13, 'My someone size floor
law', '978-0-16-100863-3', 2006, 46, 24);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (14, 'View follow important',
'978-1-72860-190-8', 2004, 18, 2);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (15, 'Offer agency wrong',
'978-0-909597-16-0', 2010, 38, 6);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (16, 'Picture specific
college to', '978-1-84146-413-8', 2023, 24, 37);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (17, 'International send much
them', '978-0-88026-591-1', 1991, 7, 10);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (18, 'Rest another medical
south upon', '978-0-314-23227-4', 1990, 3, 45);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (19, 'Together color their',
'978-0-501-70067-8', 2014, 10, 20);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (20, 'Best skill can section
write', '978-1-75771-112-8', 1992, 7, 50);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (21, 'With nature',
'978-0-08-077810-5', 2013, 5, 7);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (22, 'Safe door hear prove
could', '978-0-7917-2779-9', 2002, 2, 19);


INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (23, 'Minute way',
'978-1-4809-9311-2', 1994, 16, 41);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (24, 'Law energy total',
'978-1-84404-848-9', 2017, 17, 39);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (25, 'Seem change oil',
'978-0-462-22547-0', 2007, 15, 32);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (26, 'Develop current
author', '978-1-4712-3872-7', 1991, 20, 6);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (27, 'Whatever court consumer
notice stuff', '978-1-72220-915-5', 2014, 20, 17);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (28, 'Election best',
'978-0-00-483496-2', 2008, 5, 14);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (29, 'Share benefit',
'978-1-63110-658-3', 2014, 15, 1);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (30, 'Ten administration job
among statement', '978-0-381-43482-3', 1993, 4, 11);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (31, 'Year certainly
direction your not', '978-1-5039-1205-2', 2003, 38, 33);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (32, 'Energy guess never',
'978-0-7852-8942-5', 2010, 15, 31);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (33, 'Scientist evening
painting in include', '978-1-64850-835-6', 1997, 31, 1);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (34, 'Particular major
parent', '978-0-353-56485-5', 2021, 47, 36);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (35, 'Budget lose easy manage
plan', '978-1-374-75774-5', 2016, 16, 2);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (36, 'Ground development
everyone tree', '978-1-63134-193-9', 2014, 26, 15);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (37, 'Environment analysis',
'978-1-07-243513-6', 1995, 18, 41);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (38, 'Medical church argue
group about', '978-0-371-80237-3', 1996, 49, 34);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (39, 'Herself shake whole',
'978-1-68307-493-9', 1991, 33, 17);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (40, 'Could head play
participant', '978-1-239-22490-0', 2017, 8, 20);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (41, 'Then natural movement
yard suddenly', '978-0-04-266261-9', 1991, 10, 29);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (42, 'Skill culture explain
so', '978-0-551-15386-8', 1993, 14, 9);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (43, 'Drive let anything
face', '978-1-65705-570-4', 2016, 6, 47);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (44, 'Inside prepare',
'978-0-676-83946-3', 2024, 7, 40);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (45, 'Among job live',
'978-1-110-99134-1', 2004, 2, 22);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (46, 'Himself cut',
'978-0-263-07242-6', 1999, 5, 6);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (47, 'Same voice nation fine
woman', '978-0-913118-88-7', 1997, 22, 20);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (48, 'Court wait traditional', '978-0-313-44637-5', 2023, 41, 44);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (49, 'Newspaper affect
concern item', '978-0-636-85811-4', 2024, 3, 29);
INSERT INTO book (id, title, isbn, publishedYear, author_id, publisher_id) VALUES (50, 'Everything give
record', '978-1-62457-711-6', 2004, 40, 10);
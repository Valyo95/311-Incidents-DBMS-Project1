select * from incident;

select * from totalrequestspertype(date '2001-09-28', date '2031-09-28');

select * from totalrequestsperday('ALLEY_LIGHTS_OUT', date '2001-09-28', date '2031-09-28');
select * from mostcommonserviceperzipcode(date '2018-12-10');
select * from avgcompletiontime('2018-12-10', '2018-12-13');

select * from mostCommonRequestTypeInABox(1,1000,1,1000,'2018-12-11' );


select * from incident;

select * from totalrequestsperday('ALLEY_LIGHTS_OUT', date '2001-09-28', date '2031-09-28');
select * from totalrequestspertype(date '2001-09-28', date '2031-09-28');
select * from mostcommonserviceperzipcode(date '2018-12-10');

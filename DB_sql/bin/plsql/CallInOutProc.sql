 create or replace procedure javatest(
  p1 in varchar2,
  p2 in out varchar2,
  p3 out varchar2
  ) 
as
begin
	P2 := P1 || P2;
	p3 := P1;
end;
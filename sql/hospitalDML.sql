-- patient insert[ȯ�� ���� ���̺�]
insert into patient values('01a' , '�̰ǿ�', 'M', '5Y', '17.06.12', '010-111-1111');
insert into patient values('02b' , '������', 'F', '17Y', '05.06.26', '010-222-2222');
insert into patient values('03c' , '�踸��', 'M', '8Y', '13.08.08', '010-333-3333');

-- clinic insert [���� ���� ���̺�]
insert into clinic values('0823-001','����', 'O', 'O', 'X');
insert into clinic values('0823-002','�ź���', 'O', 'O', 'O');
insert into clinic values('0823-003','�������', 'O', 'X', 'X');

-- recipe insert [ó�� ���� ���̺�]
insert into recipe values('A','01a', '38,900��', '�׻���');
insert into recipe values('B','02b', '650,000��', '����');
insert into recipe values('C','03c', '20,000��', '�����');

-- desk insert 
insert into desk values(desk_upload_id_seq.nextval, '01a', '0823-001', 'A');
insert into desk values(desk_upload_id_seq.nextval, '02b', '0823-002', 'B');
insert into desk values(desk_upload_id_seq.nextval, '03c', '0823-003', 'C');

commit;

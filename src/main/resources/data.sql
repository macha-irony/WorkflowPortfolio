INSERT INTO roles(name)
VALUES ('ADMIN')
ON CONFLICT (name) DO NOTHING;

INSERT INTO positions(name)
VALUES
    ('部長'),
    ('課長'),
    ('社員')
    ON CONFLICT (name) DO NOTHING;

INSERT INTO approval_flows(name)
VALUES ('通常申請')
ON CONFLICT (name) DO NOTHING;

INSERT INTO leave_types(name, description, flow_id)
VALUES (
		'有給休暇',
		'通常の有給休暇',
		(SELECT id FROM approval_flows WHERE name = '通常申請')
		)
ON CONFLICT (name) DO NOTHING;

INSERT INTO users(login_id, password, name, role_id, position_id)
VALUES (
		'testid',
		'testpassword',
		'テストユーザー',
		(SELECT id FROM roles WHERE name = 'ADMIN'),
		(SELECT id FROM positions WHERE name = '部長')
		)
ON CONFLICT (login_id) DO NOTHING;
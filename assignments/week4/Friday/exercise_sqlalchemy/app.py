from sqlalchemy import create_engine, Column, Integer, String
from sqlalchemy.orm import declarative_base, Session
from sqlalchemy.exc import OperationalError

engine = create_engine("sqlite:///database.db")
Base = declarative_base()

class User(Base):
    __tablename__ = "users"

    id = Column(Integer, primary_key = True)
    name = Column(String, nullable = False)
    email = Column(String, nullable = False, unique = True)

Base.metadata.create_all(engine)

def addUser(session):
    input_name = input("Name: ")
    input_email = input("Email: ")
    try:
        user = User(name = input_name, email = input_email)
        session.add(user)
        session.commit()
    except OperationalError as e:
        print(e)

def getUsers(session):
    try:
        users = session.query(User).all()
        for user in users:
            print(f"{user.id}, {user.name}, {user.email}")
    except OperationalError as e:
        print(e)

def updateUser(session):
    input_user_id = input("User ID to be updated: ")

    user = session.get(User, input_user_id)

    if not user:
        print("User not found")
        return

    try:
        new_name = input("Name: ")
        new_email = input("Email: ")

        user.name = new_name
        user.email = new_email

        session.commit()
    except OperationalError as e:
        print(e)

def deleteUser(session):
    input_user_id = input("User ID to be deleted: ")

    user = session.get(User, input_user_id)

    if not user:
        print("User not found")
        return
    
    try:
        session.delete(user)
        session.commit()
    except OperationalError as e:
        print(e)

if __name__ == "__main__":
    with Session(engine) as session:
        while True:
            print("1. Add User, 2. Get Users, 3. Update User, 4. Delete User")
            user_input = input()

            match user_input:
                case "1":
                    addUser(session)
                case "2":
                    getUsers(session)
                case "3":
                    updateUser(session)
                case "4":
                    deleteUser(session)
                case _:
                    break
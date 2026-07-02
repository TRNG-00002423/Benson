import sqlite3

def add(cursor):
    name = input("Name: ")
    email = input("Email: ")

    cursor.execute("""
        insert into users(name, email) values(?, ?);
                   """,
        (name, email))
    
def listing(cursor):
    cursor.execute("select * from users;")
    for row in cursor.fetchall():
        print(row)
    
def update(cursor):
    id = input("User id to be updated: ")
    name = input("New name: ")
    email = input("New email: ")

    sql = """
        update users
        set name = ?, email = ?
        where id = ?;
    """
    cursor.execute(sql, (name, email, id))
    
    print(f"{cursor.rowcount} rows updated")

def delete(cursor):
    id = input("User id to be deleted: ")

    sql = """
        delete from users
        where id = ?;
    """
    cursor.execute(sql, (id))

    print(f"{cursor.rowcount} rows deleted")

create_table_query = """
create table if not exists users(
    id integer primary key,
    name text not null,
    email text unique not null
);
"""
try:
    with sqlite3.connect("database.db") as conn:
        cursor = conn.cursor()
        cursor.execute(create_table_query)

        while True:
            print("1. Add, 2. List, 3. Update, 4. Delete")

            user_input = input()

            match user_input:
                case "1":
                    add(cursor)
                case "2":
                    listing(cursor)
                case "3":
                    update(cursor)
                case "4":
                    delete(cursor)
                case _:
                    break
        conn.commit

except sqlite3.Error as e:
    print(e)

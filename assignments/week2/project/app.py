from flask import Flask, jsonify, request

app = Flask(__name__)

#student ds:
# id int, name str, course str
students = [
    {
        "id": 1,
        "name": "Alice",
        "course": "Computer Science"
    },
    {
        "id": 2,
        "name": "Bob",
        "course": "Data Science"
    }
]

current_id = 3

@app.get("/students")
def get_all_students():
    return jsonify(students), 200

@app.get("/students/<int:id>")
def get_student_by_id(id):
    for student in students:
        if student["id"] == id:
            return jsonify(student), 200
    return jsonify({"error": f"Student {id} not found"}), 404

@app.post("/students")
def create_student():
    global current_id

    data = request.get_json()

    name = data["name"]
    course = data["course"]

    new_student = {"id": current_id, "name": name, "course": course}
    students.append(new_student)
    current_id += 1

    return jsonify({"message": "Student created sucessfully", "student": new_student}), 201

@app.put("/students/<int:id>")
def update_student(id):
    global students
    updated_students = []
    data = request.get_json()
    name, course = data["name"], data["course"]

    found = 0
    for student in students:
        if student["id"] != id:
            updated_students.append(student)
        else:
            updated_student = {"id": id, "name": name, "course": course}
            updated_students.append(updated_student)
            found = 1
            students = updated_students
    
    if found:
        return jsonify(updated_student)
    else:
        return jsonify({"error": "Student not found"}), 404

@app.delete("/students/<int:id>") 
def delete_student_by_id(id):
    global students
    found = 0
    updated_students = []

    for student in students:
        if student["id"] != id:
            updated_students.append(student)
        else:
            found = 1
    
    if found:
        students = updated_students
        return jsonify({"message": "Student deleted successfully"}), 200
    else:
        return jsonify({"error": "Student not found"}), 404
    
if __name__ == "__main__":
    app.run(debug=True)
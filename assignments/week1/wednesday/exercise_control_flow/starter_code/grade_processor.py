def grade_program(scores):
    lowest_score = float("inf")
    highest_score = float("-inf")
    total_max_score = 0
    total_score = 0

    grade_count = {"A": 0, "B": 0, "C": 0, "D": 0, "F": 0}
    
    for _, score in enumerate(scores):
        if score == -999:
            break
        if score < 0:
            continue
        highest_score = max(highest_score, score)
        lowest_score = min(lowest_score, score)
        total_score += score
        total_max_score += 100
        if score >= 90:
            grade_count["A"] += 1
        elif score >= 80:
            grade_count["B"] += 1
        elif score >= 70:
            grade_count["C"] += 1
        elif score >= 60:
            grade_count["D"] += 1
        else:
            grade_count["F"] += 1

        print(score)

    print(f"Avg score: {total_score / total_max_score * 100:.2f}")
    print(f"Highest score: {highest_score}")
    print(f"Lowest score: {lowest_score}")

    for grade, count in grade_count.items():
        print(f"{grade}: {count}")

scores = [88, 92, 75, -1, 63, 95, 81, 70, -5, 55, 100, 78, -999, 90, 85]
grade_program(scores)


        
        
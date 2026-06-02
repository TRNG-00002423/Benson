"""
QA Test Metrics Calculator
Fill in the code below where you see # TODO comments.
"""

def main():
    print("═" * 40)
    print("  QA Test Metrics Calculator")
    print("═" * 40)

    # TODO 1: Get user input
    # - Total test cases (convert to int)
    # - Passed tests (convert to int)
    # - Total execution time in seconds (convert to float)
    total_tests = int(input("Enter total test cases:" ))
    passed_tests = int(input("Enter passed tests: "))
    total_time = float(input("Enter total execution time (seconds): "))

    # TODO 2: Calculate metrics
    # - failed tests
    # - pass rate (as percentage)
    # - fail rate (as percentage)
    # - average time per test
    failed_tests = total_tests - passed_tests
    pass_rate = passed_tests / total_tests
    fail_rate = failed_tests / total_tests
    avg_time = total_time / total_tests 

    # TODO 3: Print the results summary using f-strings
    # Use the format shown in the README
    print("═" * 40)
    print("  Test Results Summary")
    print("═" * 40)

    print(f"{'Total Tests: ':<18} {total_tests}")
    print(f"{'Passed: ':<18} {passed_tests}")
    print(f"{'Failed: ':<18} {failed_tests}")
    print(f"{'Pass Rate: ':<18} {pass_rate:.2%}")
    print(f"{'Fail Rate: ':<18} {fail_rate:.2%}")
    print(f"{'Avg Time/Tests: ':<18} {avg_time}s")
    print(f"{'Total Time: ':<18} {total_time}s")

    # TODO 4: Determine and print the verdict
    # >= 95% → RELEASE APPROVED
    # >= 80% → CONDITIONAL RELEASE
    # else   → RELEASE BLOCKED
    print("\n")
    if pass_rate >= .95:
         print("Verdict: ✅ RELEASE APPROVED")
    elif pass_rate >= .8:
        print("Verdict: ⚠️ CONDITIONAL RELEASE — review failures")
    else:
        print("Verdict: ❌ RELEASE BLOCKED — too many failures")

    print("═" * 40)
if __name__ == "__main__":
    main()
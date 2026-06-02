class Test:
    def __init__(self, name, duration, is_pass):
        self.name = name
        self.duration = duration
        self.pass_str = "❌ FAIL"
        if is_pass:
            self.pass_str = "✅ PASS"
        self.is_pass = is_pass


tests = [Test("test_login", 1200, True), Test("test_search", 850, True), Test("test_checkout", 2300, False), Test("test_profile", 450, True), Test("test_logout", 180, True)]
total_duration = 0
total_passed = 0
total_test = 0
for test in tests:
    total_test += 1
    if test.is_pass:
        total_passed += 1
    total_duration += test.duration

total_duration_str = str(total_duration) + " ms"

def print_tests():
    for test in tests:
        print(f"{f'| {test.name}':<20} | {f'{test.duration} ms':<12} | {f'{test.pass_str} ':<11} |")

print("┌" + "─" * 50 + "┐")
print(f"{f'| Test Name':<20} | {f'Duration':<12} | {f'Status: ':<12} |")
print("├" + "─" * 50 + "┤")
print_tests()
print("├" + "─" * 50 + "┤")
print(f"{f'| TOTAL':<20} | {total_duration_str:<12} | {f'{total_passed} / {total_test} Pass ':<12} |")
print("└" + "─" * 50 + "┘")


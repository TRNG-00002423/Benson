class TestCase:
    """Represents a single test case.

    Class Attributes:
        total_created (int): Count of all TestCase objects ever created

    Instance Attributes:
        name (str): Test name (e.g., "test_login_valid")
        description (str): What this test verifies
        priority (str): "high", "medium", or "low" (default: "medium")
        tags (list): Labels like ["smoke", "regression"]
    """
    # TODO: Implement __init__, run(), and a class method
    total_created = 0

    def __init__(self, name="", description="", priority="", tags=None):
        self.name = name
        self.description = description
        self.priority = priority
        self.tags = tags if tags else []

        TestCase.total_created += 1

    def run(self):
        """Simulate running the test. Return True for pass, False for fail.
        For now, use: return "fail" not in self.name
        """
        return "fail" not in self.name

    @classmethod
    def from_dict(cls, data):
        """Create a TestCase from a dictionary.
        Example: TestCase.from_dict({"name": "test_login", "priority": "high"})
        """
        name = data.get("name", "")
        description = data.get("description", "") 
        priority = data.get("priority", "medium")
        tags = data.get("tags", [])

        return cls(name, description, priority, tags)

    @staticmethod
    def is_valid_name(name):
        """Check if name starts with 'test_' and has no spaces."""
        for char in name:
            if char == " ":
                return False

        if len(name) < 5 or char[:5] != "test_":
            return False
        
        return True

class TestResult:
    """The outcome of running a single test.

    Instance Attributes:
        test_name (str): Which test was run
        status (str): "pass" or "fail"
        duration_ms (float): How long it took
        error_message (str or None): Error details if failed
    """
    # TODO: Implement
    
    def __init__(self, test_name, status, duration_ms, error_message):
        self.test_name = test_name
        self.status = status
        self.duration_ms = duration_ms
        self.error_message = error_message

    def summary(self):
        icon = "❌"
        if self.status == "pass":
            icon = "✅"

        """Return a one-line summary like: '✅ test_login (120ms)'"""
        return f"{icon} {self.test_name} ({self.duration_ms}ms)"
    
class TestSuite:
    """A collection of test cases.

    Instance Attributes:
        name (str): Suite name
        tests (list): List of TestCase objects

    Methods:
        add_test(test): Add a TestCase
        remove_test(name): Remove by name
        get_by_priority(priority): Return tests matching the priority
        count(): Return number of tests
    """
    # TODO: Implement
    def __init__(self, name, tests):
        self.name = name
        self.tests = tests
    
    def add_test(self, test):
        self.tests.append(test)

    def remove_test(self, name):
        self.tests = [test for test in self.tests if test.name != name]

    def get_by_priority(self, priority):
        return [test for test in self.tests if test.priority == priority]
    
    def count(self):
        return len(self.tests)
    
class TestRunner:
    """Executes a TestSuite and collects results.

    Methods:
        run(suite): Run all tests in a suite, return list of TestResult
        summary(results): Print a formatted summary
    """
    # TODO: Implement
    @staticmethod
    def run(suite):
        """Run each test in the suite and return a list of TestResults."""
        import time
        import random
        results = []
        for test in suite.tests:
            start = time.time()
            passed = test.run()
            duration = (time.time() - start) * 1000
            # Simulate varying duration
            duration += random.uniform(50, 500)
            result = TestResult(
                test.name,
                "pass" if passed else "fail",
                round(duration, 1),
                None if passed else f"{test.name} assertion failed"
            )
            results.append(result)
        return results
    
    @staticmethod
    def summary(results):
        for result in results:
            print(result.summary())

if __name__ == "__main__":
    test_cases = [
        TestCase("test_login_valid"), 
        TestCase.from_dict({"name": "test_search_product"}),
        TestCase.from_dict({"name": "test_checkout_fail", "priority": "high"}),
        TestCase("test_profile_update"),
        TestCase("test_payment_fail"),
        TestCase("test_logout_success")
    ]

    test_suite = TestSuite("test_suite_1", test_cases)

    high_priority_tests = test_suite.get_by_priority("high")
    print("High priority tests: ")

    for high_priority_test in high_priority_tests:
        print(high_priority_test)

    results = TestRunner.run(test_suite)
    TestRunner.summary(results)
"""
    Create a main() function that:

Creates 6+ TestCase objects (mix of passing and failing names).
Uses TestCase.from_dict() for at least 2 of them.
Creates a TestSuite and adds all tests.
Uses get_by_priority("high") to list high-priority tests.
Runs the suite with TestRunner.
Prints the results summary.
"""

   
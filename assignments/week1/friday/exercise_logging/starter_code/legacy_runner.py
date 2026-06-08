"""
LEGACY CODE — This file uses print() everywhere.
YOUR TASK: Replace all print() calls with appropriate logging calls.
"""
from logging_config import setup_logging
import time
import random

logger = setup_logging()

def run_test(test_name):
    """Run a single test (simulated)."""
    logger.info(f"Running test: {test_name}")       # TODO: Log at appropriate level
    duration = random.uniform(0.1, 2.0)
    time.sleep(0.01)  # Simulate work

    if random.random() < 0.2:
        logger.error(f"ERROR: {test_name} failed!")   # TODO: Log as ERROR
        print(f"  Duration: {duration:.2f}s")
        return False

    logger.info(f"{test_name} passed ({duration:.2f}s)")  # TODO: Log as INFO
    return True


def run_suite(suite_name, test_names):
    """Run a suite of tests."""
    print(f"\n{'='*50}")
    logger.info(f"Starting suite: {suite_name}")     # TODO: Log as INFO
    print(f"Tests to run: {len(test_names)}")
    print(f"{'='*50}\n")

    results = {"passed": 0, "failed": 0}

    for i, test in enumerate(test_names, 1):
        logger.info(f"[{i}/{len(test_names)}] Running test: {test}")  # TODO: Log with context
        if run_test(test):
            results["passed"] += 1
        else:
            results["failed"] += 1

    total = results["passed"] + results["failed"]
    rate = results["passed"] / total * 100

    print(f"\n{'='*50}")
    print(f"Results: {results['passed']}/{total} passed ({rate:.1f}%)")

    if rate < 80:
        logger.warning(f"WARNING: Pass rate below 80%!")  # TODO: Log as WARNING
    if rate < 50:
        logger.critical(f"CRITICAL: More than half the tests failed!")  # TODO: CRITICAL

    return results


def main():
    logger.info("QA Test Framework v1.0")        # TODO: Log as INFO
    print("Initializing...")

    suites = {
        "Smoke Tests": ["test_login", "test_homepage", "test_search"],
        "Regression": ["test_checkout", "test_payment", "test_profile",
                       "test_settings", "test_logout"],
        "Performance": ["test_load_page", "test_api_response"],
    }

    all_results = {"passed": 0, "failed": 0}

    for suite_name, tests in suites.items():
        try:
            result = run_suite(suite_name, tests)
            all_results["passed"] += result["passed"]
            all_results["failed"] += result["failed"]
        except Exception as e:
            logger.error(f"Suite {suite_name} crashed: {e}", exc_info=True)  # TODO: Log with exc_info

    total = all_results["passed"] + all_results["failed"]
    print(f"\nFinal: {all_results['passed']}/{total} overall")


if __name__ == "__main__":
    main()
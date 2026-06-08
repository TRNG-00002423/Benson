"""
Configure logging for the QA Test Framework.

Requirements:
1. Console handler: Show INFO and above, concise format
2. File handler: Capture DEBUG and above, detailed format with timestamps
3. Use a RotatingFileHandler (max 1MB, keep 3 backups)
"""

import logging
from logging.handlers import RotatingFileHandler


def setup_logging(log_file="test_framework.log", console_level=logging.INFO):
    """Configure and return the root logger for the framework.

    Args:
        log_file: Path to the log file
        console_level: Minimum level for console output

    Returns:
        logging.Logger configured with both handlers
    """
    # TODO: Create logger named "qa_framework"
    logger = logging.getLogger("qa_framework")
    logger.setLevel(logging.DEBUG)
    # TODO: Add StreamHandler for console (INFO+)
    streamHandler = logging.StreamHandler()
    streamHandler.setLevel(logging.INFO)
    # TODO: Add RotatingFileHandler for file (DEBUG+)
    rotatingFileHandler = RotatingFileHandler("qa_framework.log", maxBytes=1024 * 1024, backupCount=3)
    rotatingFileHandler.setLevel(logging.DEBUG)
    # TODO: Set appropriate formatters on each handler
    formatter = logging.Formatter("%(asctime)s | %(levelname)-8s | %(message)s")
    streamHandler.setFormatter(formatter)
    rotatingFileHandler.setFormatter(formatter)
    # TODO: Return the configured logger
    logger.addHandler(streamHandler)
    logger.addHandler(rotatingFileHandler)

    return logger
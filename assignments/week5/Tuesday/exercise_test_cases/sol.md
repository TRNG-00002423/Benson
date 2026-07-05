## TC-BT-001 — Positive: Create wishlist with valid name

**Preconditions:**

* User A is signed in with a valid bearer token.
* User A has fewer than 10 wishlists.
* Wishlist name `Summer Reading` does not already exist for User A.

**Steps:**

1. Send `POST /wishlists` with name `Summer Reading`.
2. View User A’s wishlist list.

**Expected result:**

* API returns `201 Created`.
* Response includes a new wishlist ID and name `Summer Reading`.
* Wishlist appears in User A’s wishlist list.

**Priority:** P1 — Core feature; users must be able to create wishlists.

**Traceability:** AC1

---

## TC-BT-002 — Positive: Trim leading and trailing spaces in wishlist name

**Preconditions:**

* User A is signed in.
* User A has fewer than 10 wishlists.
* User A does not already have a wishlist named `Sci Fi`.

**Steps:**

1. Send `POST /wishlists` with name `   Sci Fi   `.
2. Retrieve User A’s wishlist list.

**Expected result:**

* API returns `201 Created`.
* Stored wishlist name is `Sci Fi`.
* Leading and trailing spaces are not saved.

**Priority:** P2 — Prevents confusing duplicate-looking names and bad data.

**Traceability:** AC1

---

## TC-BT-003 — Positive: Add book to wishlist

**Preconditions:**

* User A is signed in.
* User A owns wishlist `WL-A1`.
* Wishlist `WL-A1` has fewer than 50 books.
* Book ID `BOOK-UUID-1` exists in the catalog and is not already in the wishlist.

**Steps:**

1. Send `POST /wishlists/WL-A1/books` with book ID `BOOK-UUID-1`.
2. Retrieve wishlist `WL-A1`.

**Expected result:**

* API returns `200 OK` or `201 Created`.
* Wishlist `WL-A1` contains book ID `BOOK-UUID-1`.
* No duplicate book entry is created.

**Priority:** P1 — Adding books is a main user workflow.

**Traceability:** AC3

---

## TC-BT-004 — Positive: Remove deleted catalog book from wishlist

**Preconditions:**

* User A is signed in.
* User A owns wishlist `WL-A1`.
* Wishlist `WL-A1` contains book ID `BOOK-UUID-DELETED`.
* Book ID `BOOK-UUID-DELETED` was deleted from the catalog.

**Steps:**

1. Send `DELETE /wishlists/WL-A1/books/BOOK-UUID-DELETED`.
2. Retrieve wishlist `WL-A1`.

**Expected result:**

* API returns `200 OK`, `204 No Content`, or documented successful delete status.
* Book ID `BOOK-UUID-DELETED` is no longer in wishlist `WL-A1`.
* No catalog lookup error is shown to the user.

**Priority:** P2 — Important cleanup flow; deleted catalog items should not block user actions.

**Traceability:** AC4

---

## TC-BT-005 — Negative: Reject empty wishlist name after trim

**Preconditions:**

* User A is signed in.
* User A has fewer than 10 wishlists.

**Steps:**

1. Send `POST /wishlists` with name `"     "`.

**Expected result:**

* API returns `400 Bad Request`.
* Wishlist is not created.
* Error message or code indicates the name cannot be empty after trimming.

**Priority:** P1 — Prevents invalid user data.

**Traceability:** AC1

---

## TC-BT-006 — Negative: Reject wishlist name longer than 40 characters

**Preconditions:**

* User A is signed in.
* User A has fewer than 10 wishlists.

**Steps:**

1. Send `POST /wishlists` with a 41-character name, such as `AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA`.

**Expected result:**

* API returns `400 Bad Request`.
* Wishlist is not created.
* Error message or code indicates the name must be 1–40 characters.

**Priority:** P2 — Boundary validation prevents invalid data and UI/display issues.

**Traceability:** AC1

---

## TC-BT-007 — Negative: Reject duplicate case-insensitive wishlist name

**Preconditions:**

* User A is signed in.
* User A already has a wishlist named `Fantasy`.

**Steps:**

1. Send `POST /wishlists` with name `fantasy`.

**Expected result:**

* API returns `409 Conflict` or documented validation error status.
* Response includes error code `WL_DUP_NAME`.
* No second wishlist named `fantasy` is created for User A.

**Priority:** P1 — Prevents duplicate lists and directly validates required error code.

**Traceability:** AC2

---

## TC-BT-008 — Negative/Boundary: Reject creating 11th wishlist

**Preconditions:**

* User A is signed in.
* User A already owns exactly 10 wishlists.

**Steps:**

1. Send `POST /wishlists` with name `Extra List`.

**Expected result:**

* API returns `400 Bad Request`, `409 Conflict`, or documented limit error status.
* Wishlist is not created.
* User A still has exactly 10 wishlists.

**Priority:** P1 — Required account limit; prevents users from exceeding system constraints.

**Traceability:** AC1

---

## TC-BT-009 — Negative/Boundary: Adding 51st distinct book returns WL_FULL

**Preconditions:**

* User A is signed in.
* User A owns wishlist `WL-A1`.
* Wishlist `WL-A1` already contains exactly 50 distinct books.
* Book ID `BOOK-UUID-51` exists in the catalog and is not already in the wishlist.

**Steps:**

1. Send `POST /wishlists/WL-A1/books` with book ID `BOOK-UUID-51`.
2. Retrieve wishlist `WL-A1`.

**Expected result:**

* API returns `409 Conflict` or documented limit error status.
* Response includes error code `WL_FULL`.
* Book ID `BOOK-UUID-51` is not added.
* Wishlist still contains exactly 50 distinct books.

**Priority:** P1 — Explicit required boundary case; protects wishlist size limit.

**Traceability:** AC3

---

## TC-BT-010 — Negative/Security: Non-owner cannot view another user’s wishlist

**Preconditions:**

* User A owns wishlist `WL-A1`.
* User B is signed in with a valid bearer token.
* User B does not own wishlist `WL-A1`.

**Steps:**

1. As User B, send `GET /wishlists/WL-A1`.

**Expected result:**

* API returns `404 Not Found`.
* Response does not reveal that wishlist `WL-A1` exists.
* No wishlist data is returned.

**Priority:** P1 — Prevents privacy leak and enumeration of another user’s data.

**Traceability:** AC5

---

## TC-BT-011 — Negative/Security: Non-owner cannot modify another user’s wishlist

**Preconditions:**

* User A owns wishlist `WL-A1`.
* User B is signed in with a valid bearer token.
* Book ID `BOOK-UUID-2` exists in the catalog.

**Steps:**

1. As User B, send `POST /wishlists/WL-A1/books` with book ID `BOOK-UUID-2`.
2. As User A, retrieve wishlist `WL-A1`.

**Expected result:**

* User B’s request returns `404 Not Found`.
* Response does not reveal that wishlist `WL-A1` exists.
* Book ID `BOOK-UUID-2` is not added to User A’s wishlist.

**Priority:** P1 — Prevents unauthorized modification of user data.

**Traceability:** AC5

---

## TC-BT-012 — NFR/Performance: Retrieve wishlist with 50 items within p95 target

**Preconditions:**

* Staging environment is running on documented reference hardware.
* User A is signed in.
* User A owns wishlist `WL-A1`.
* Wishlist `WL-A1` contains exactly 50 books.
* Test plan defines sample size, tool, and acceptable network conditions.

**Steps:**

1. Run a performance test that sends repeated `GET /wishlists/WL-A1` requests as User A.
2. Collect response times for enough requests to calculate p95 latency.
3. Compare p95 response time against the NFR target.

**Expected result:**

* Wishlist retrieval p95 response time is `≤ 800 ms`.
* Response contains all 50 wishlist items.
* Performance result is documented in the test report.

**Priority:** P2 — Performance affects usability, especially for full wishlists.

**Traceability:** AC6

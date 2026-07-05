# Scenarios to classify

1. A tester executes a **regression suite** on release candidate `2.3.0` before go-live.
2. The team adopts **trunk-based development** with **required CI checks** on every pull request.
3. A **usability test** with five nurses observes whether they can complete **medication reconciliation** without training.
4. A **code review** finds an **off-by-one** error before merge.
5. The **PO** runs a **sprint review** with stakeholders and learns the **workflow** does not match **real clinic** practice.
6. QA **updates** the **test data refresh** runbook after staging was stale for two sprints.
7. An **external auditor** requests **traceability** from requirement IDs to test case IDs for SOX scope features.
8. Developers add **contract tests** between **billing** and **subscriptions** services to catch API drift early.
9. A **blameless postmortem** after an outage produces **three** action items to improve **deployment** safety.
10. A tester **files** a bug: totals on the invoice PDF **do not match** the cart API response.
11. The team defines **Definition of Done** to include “**no open critical defects**” for sprint work.
12. Marketing runs an **A/B test** on checkout copy and picks the variant with **higher conversion**.

| # | Scenario | QA or QC | V or Val | One-line rationale |

1 | Regression suite before going live | QC | V | Confirming if old features still work correctly
2 | Trunk-based development with CI checks | QA | V | Strategy for coding to achieve quality code
3 | Usuability without assistance testing for nurses | QC | Val | Checks if the targeted audience can use it
4 | Code review finds off by one error | QC | V | Checks for errors before merging
5 | PO sprint review with stakeholders | QC | Val | Checks if building the correct product for the intended purposes
6 | QA updating tests | QA | V | Keeping test up to date to prevent issues
7 | Requesting tracability matrix | QA | V | Checking full testing process
8 | Adding additional tests | QA | V | Being more cautious with potential bugs
9 | Improving deployment safety with new actions | QA | V | Improve process after failure
10 | Filing a bug | QC | V | Defect did not match system behavior
11 | Defining DoD | QA | V | Defining standards to be held
12 | A\B testing | QC | Val | Checking the ways for the product to achieve its purpose
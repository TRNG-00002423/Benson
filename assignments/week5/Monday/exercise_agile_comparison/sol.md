# MediChart Analytics Lifecycle Recommendation

I recommend a **hybrid lifecycle**.

For **Phase A, the first 12 months with pilot hospitals**, MediChart should use **Agile/Scrum with regulatory controls**. Agile fits this phase because the team expects weekly learning from pilot hospitals, and workflows, metrics, and report layouts will change often during the first 9–12 months. The team is also small, with 8 people who can sit together daily, so fast communication, sprint planning, standups, and backlog refinement are realistic. A pure Waterfall model would be too rigid because the requirements are not stable yet.

However, MediChart cannot ignore regulatory needs. Regulators require an auditable requirements baseline and formal verification evidence before live patient data can be connected. To handle this, documentation should be built into each sprint. Every story should include acceptance criteria, traceability to requirements, test cases, review notes, and verification evidence. The team should keep a versioned requirements baseline and update it whenever pilot feedback changes the product. Test results, CI logs, review approvals, and release notes should be saved as evidence.

For **Phase B, the 18-month rollout to 40 sites**, MediChart should shift to a more **plan-driven hybrid model**. The hospital group wants a fixed-price contract, frozen scope, predictable milestones, and documentation. Agile can still be used internally, but scope changes should go through formal change control.

The main risk is that documentation could slow the team down. MediChart can reduce this by using lightweight templates and automating evidence collection through CI, test reports, and pull request reviews. Another risk is scope creep from weekly pilot feedback. The product lead should keep new ideas in the backlog and only commit them after prioritization and clear acceptance criteria. A third risk is moving from flexible Phase A to fixed-scope Phase B. MediChart should create a formal Phase B baseline before rollout and use change control after that.

My testing philosophy is **shift-left testing**. Testers should be involved during backlog refinement, before coding starts. Each story should have acceptance criteria, test scenarios, and required verification evidence defined early. CI checks should run automated tests on every pull request so defects and compliance gaps are caught early, not at the end.

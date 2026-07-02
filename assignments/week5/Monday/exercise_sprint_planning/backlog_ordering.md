US-207 — Fix incorrect mortality rate when denominator is zero
US-201 — Role-based access so only authorized staff see PHI
US-203 — Exportable audit trail of dashboard views
US-205 — Spike: evaluate hosted SIEM vs self-managed for log retention
US-208 — SSO with hospital IdP
US-202 — Daily readmission risk trends filtered by ward
US-204 — CSV export of a dashboard slice
US-206 — Dark mode

Rationale:

We prioritized safety, compliance, and trust first because this is a healthcare dashboard handling PHI and clinical metrics. Incorrect mortality data and weak access control are high-risk.

We placed audit trail and SIEM research early because regulatory evidence and log retention affect many future stories.

We delayed lower-risk usability features like CSV export and dark mode because they provide value but are less urgent than data correctness, PHI protection, and auditability.
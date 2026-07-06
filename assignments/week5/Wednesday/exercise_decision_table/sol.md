# Decision Table — Checkout Shipping Discount

## Conditions

| Condition | Meaning |
|---|---|
| PromoActive | Whether the global shipping discount promo is active |
| CartSubtotal ≥ 75 | Whether the cart subtotal meets the discount threshold |
| CustomerTier | Customer is either Gold or Standard |

## Decision Table

| Rule | R1 | R2 | R3 | R4 | R5 | R6 |
|---|---:|---:|---:|---:|---:|---:|
| PromoActive = Y? | N | N | Y | Y | Y | Y |
| CartSubtotal ≥ 75? | - | - | N | N | Y | Y |
| CustomerTier | Standard | Gold | Standard | Gold | Standard | Gold |
| **DiscountPercent** | **0** | **0** | **0** | **0** | **10** | **15** |

## Rule Captions

- **R1:** Promo is inactive, Standard customer gets 0% shipping discount.
- **R2:** Promo is inactive, Gold customer gets 0% shipping discount.
- **R3:** Promo is active, but Standard customer subtotal is below $75, so discount is 0%.
- **R4:** Promo is active, but Gold customer subtotal is below $75, so discount is 0%.
- **R5:** Promo is active, subtotal is at least $75, and customer is Standard, so shipping discount is 10%.
- **R6:** Promo is active, subtotal is at least $75, and customer is Gold, so shipping discount is 15%.

## Don't Care Justification

For R1 and R2, `CartSubtotal ≥ 75` is marked as `-` because when `PromoActive = N`, the rule says the discount is 0 for everyone regardless of cart subtotal.
CREATE VIEW finantial_report AS
SELECT
	oo.name "Office Object Name",
	oot.name "Type",
	fint.name "deal",
	oof.cost,
	oof.action_date "Date"
FROM office_oject_financial oof
JOIN office_oject oo 			ON oo.id = oof.office_oject_id
JOIN financial_types fint 		ON fint.id = oof.financial_types_id
JOIN office_oject_type oot 		ON oot.id = oo.office_oject_type_id;
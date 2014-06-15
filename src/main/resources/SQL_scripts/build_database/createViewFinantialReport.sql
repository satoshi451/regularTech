CREATE VIEW finantial_report AS
SELECT
	oo.name "Office Object Name",
	oot.name "Type",
	fint.name "deal",
	oof.cost,
	oof.action_date "Date"
FROM office_object_finantial oof
JOIN office_object oo 			ON oo.id = oof.office_object_id
JOIN finantial_types fint 		ON fint.id = oof.finantial_types_id
JOIN office_object_type oot 		ON oot.id = oo.office_object_type_id;